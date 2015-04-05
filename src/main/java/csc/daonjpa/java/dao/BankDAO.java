package csc.daonjpa.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csc.daonjpa.java.domain.Bank;

@Repository
public class BankDAO {

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * Get all bank of database
	 * Return List<Bank>
	 */
	@Transactional
	public List<Bank> getBank() {
		TypedQuery<Bank> query = entityManager.createQuery(
				"SELECT c FROM Bank c", Bank.class);
		List<Bank> results = query.getResultList();
		return results;
	}

}
