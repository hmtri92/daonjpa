package csc.daonjpa.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csc.daonjpa.java.domain.TargetAccount;

@Repository
public class TargetAccountDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public boolean addNewTarget(String accountOwner, String accountNumber, String nameTarget,
			int bank, int branch) {
		try {
		String sql = "INSERT INTO tagetAccount(accountOwner, accountNumber, name, id_bank, id_branch) "
				+ "VALUE(:accountOwner, :accountNumber, :name, :bank, :branch )";
		
		entityManager.createNativeQuery(sql)
			.setParameter("accountOwner", accountOwner)
			.setParameter("accountNumber", accountNumber)
			.setParameter("name", nameTarget)
			.setParameter("bank", bank)
			.setParameter("branch", branch)
			.executeUpdate();
		return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public List<TargetAccount> getTargetByAccount(long accountOwner) {
		List<TargetAccount> targetAccounts = null;
		
		String sql = "SELECT t FROM TargetAccount t WHERE t.accountOwner.id = :accountOwner";
		TypedQuery<TargetAccount> query = entityManager.createQuery(sql, TargetAccount.class);
		query.setParameter("accountOwner", accountOwner);
		
		targetAccounts = query.getResultList();
		
		return targetAccounts;
	}

	public TargetAccount getAccountNumber(long recentAccount) {
//		String sql = "SELECT t.accountNumber.id FROM TargetAccount t WHERE t.id_taget = :recentAccount";
//		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
//		query.setParameter("recentAccount", recentAccount);
//		
//		long idAccount = query.getSingleResult();
		
		TargetAccount targetAccount = entityManager.find(TargetAccount.class, recentAccount);
		
		return targetAccount;
	}

}
