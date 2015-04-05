package csc.daonjpa.java.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;
import csc.daonjpa.java.domain.LogTransaction;

@Repository("transferDAO")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class TransferDAO {

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * Get all Bank
	 */
	public List<Bank> getBank() {
		TypedQuery<Bank> query = entityManager.createQuery(
				"SELECT c FROM Bank c", Bank.class);
		List<Bank> results = query.getResultList();
		return results;
	}

	public List<Branch> getBranchByBank(int id) {
		TypedQuery<Branch> query = entityManager.createQuery(
				"SELECT c FROM Branch c where c.bank.id_bank=?1", Branch.class);
		List<Branch> results = query.setParameter(1, id).getResultList();
		return results;
	}

	/*
	 * 
	 */
	@Transactional
	public int insertTransaction(long amount, Date date, long id_branch,
			long id_receiveaccount, long id_sendaccount) {
		String sql = "insert into LogTransaction(amount,sendAccount,receiveAccount,id_branch,date) values (?,?,?,?,?)";
		TypedQuery<LogTransaction> query = (TypedQuery<LogTransaction>) entityManager
				.createNativeQuery(sql, LogTransaction.class);
		query.setParameter(1, amount);
		query.setParameter(2, id_sendaccount);
		query.setParameter(3, id_receiveaccount);
		query.setParameter(4, id_branch);
		query.setParameter(5, date);
		return query.executeUpdate();
	}

	/*
	 * Tranfer money and log transaction
	 */
	@Transactional
	public boolean sendAmount(long sendAccount_id, long rece_id, long amount,
			int banch_id) {
		
		// get money rece account
		String sql = "SELECT a.availableAmount FROM Account a WHERE a.id = :rece_id";
		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class); 
		query.setParameter("rece_id", rece_id);
		long moneyrece = query.getSingleResult();
		moneyrece += amount;
		
		// set money rece account
		sql = "UPDATE Account a SET availableAmount = :moneyrece WHERE a.id = :id";
		int count = entityManager.createQuery(sql)
					.setParameter("moneyrece", moneyrece)
					.setParameter("id", rece_id)
					.executeUpdate();
		
		// get money send account
		sql = "SELECT a.availableAmount FROM Account a WHERE a.id = :sendAccount_id";
		query = entityManager.createQuery(sql, Long.class);
		query.setParameter("sendAccount_id", sendAccount_id);
		moneyrece = query.getSingleResult();
		moneyrece -= amount;
		
		// set money send account
		sql = "UPDATE Account a SET availableAmount = :moneyrece WHERE a.id = :id";
		count = entityManager.createQuery(sql)
				.setParameter("moneyrece", moneyrece)
				.setParameter("id", sendAccount_id)
				.executeUpdate();
		
		// log transaction
		sql = "INSERT INTO LogTransaction(sendAccount, receiveAccount, id_branch, date, amount)"
				+ "VALUE(:sendAccount, :receiveAccount, :id_branch, :date, :amount)";
		entityManager.createNativeQuery(sql)
		.setParameter("sendAccount", sendAccount_id)
		.setParameter("receiveAccount", rece_id)
		.setParameter("id_branch", banch_id)
		.setParameter("date", new Date())
		.setParameter("amount", amount)
		.executeUpdate();
		
		return true;
	}

	
}
