package csc.daonjpa.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TargetAccountDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public boolean addNewTarget(String accountOwner, String accountNumber,
			int bank, int branch) {
		try {
		String sql = "INSERT INTO tagetAccount(accountOwner, accountNumber, id_bank, id_branch) VALUE(:accountOwner, :accountNumber, :bank, :branch )";
		entityManager.createNativeQuery(sql)
			.setParameter("accountOwner", accountOwner)
			.setParameter("accountNumber", accountNumber)
			.setParameter("bank", bank)
			.setParameter("branch", branch)
			.executeUpdate();
		return true;
		} catch (Exception e) {
			return false;
		}
	}

}
