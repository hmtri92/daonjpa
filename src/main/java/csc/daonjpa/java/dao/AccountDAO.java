package csc.daonjpa.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

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

	public Account checkAccount(String accountName) {
		TypedQuery<Account> query = entityManager.createQuery(
				"SELECT a FROM Account a WHERE a.accountName = :name",
				Account.class);
		return query.setParameter("name", accountName).getSingleResult();
	}

	public String getNameById(long idAccount) {
		Account account = (Account)entityManager.find(Account.class, idAccount);
		return account.getAccountName();
	}

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

	/*	*//**
	 * @return all accounts from Account table
	 */
	/*
	 * public List<Account> getAccounts() {
	 * 
	 * // Obtains entity manager object EntityManager entityManager =
	 * EntityManagerFactoryUtil.createEntityManager();
	 * 
	 * // Obtains transaction from entity manager EntityTransaction entr =
	 * entityManager.getTransaction();
	 * 
	 * // -----------Begin transaction----------- List<Account> accounts = null;
	 * try { entr.begin(); // Get a list of accounts from DB TypedQuery<Account>
	 * query = entityManager.createQuery("SELECT a FROM Account a",
	 * Account.class); accounts = query.getResultList(); entr.commit(); } catch
	 * (Exception e) { entityManager.close(); } // -----------End
	 * transaction-----------
	 * 
	 * return accounts;
	 * 
	 * }
	 *//**
	 * Add account to Account table
	 * 
	 * @param account
	 *            Account entity that contains mapped with each column in
	 *            Account table
	 * @return
	 */
	/*
	 * public boolean addAccount(Account account) { // Obtains entity manager
	 * object EntityManager entityManager =
	 * EntityManagerFactoryUtil.createEntityManager();
	 * 
	 * // Obtains transaction from entity manager EntityTransaction entr =
	 * entityManager.getTransaction();
	 * 
	 * try { // -----------Begin transaction----------- entr.begin(); // Insert
	 * a row to Account table entityManager.persist(account); entr.commit(); }
	 * catch (Exception e) { entityManager.close(); } // -----------End
	 * transaction-----------
	 * 
	 * return true; }
	 */
}
