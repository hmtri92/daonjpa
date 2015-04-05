package csc.daonjpa.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csc.daonjpa.java.domain.Account;

/**
 * DAO class for Account entity. This class contains all methods that
 * inserts/updates/deletes account info
 * 
 * @author nvu3
 *
 */
@Repository("accountDAO")
public class AccountDAO {

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * 
	 */
	@Transactional
	public Account checkAccount(String accountName) {
		TypedQuery<Account> query = entityManager.createQuery(
				"SELECT a FROM Account a WHERE a.accountName = :name",
				Account.class);
		return query.setParameter("name", accountName).getSingleResult();
	}

	/*
	 * Get name account by Id
	 */
	@Transactional
	public String getNameById(long idAccount) {
		Account account = (Account)entityManager.find(Account.class, idAccount);
		return account.getAccountName();
	}

	/*
	 * Check money in availableAmount of Account
	 */
	@Transactional
	public boolean checkMoneyByAccount(long account, long moneySend) {
		String sql = "SELECT acc.availableAmount FROM Account acc WHERE acc.id = :account";
		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		query.setParameter("account", account);
		long availableAmount = query.getSingleResult();
		
		if ((availableAmount - moneySend) > 50000) {
			return true;
		} else {
			return false;
		}
	}
}
