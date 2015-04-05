package csc.daonjpa.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import csc.daonjpa.java.domain.Branch;

@Repository
public class BranchDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * Get Branch by bankId
	 */
	@Transactional
	public List<Branch> getBranchBy(int bankId) {
		List<Branch> branchs = new ArrayList<Branch>();
		
		String sql = "SELECT b FROM Branch b WHERE b.bank.id_bank = :bank";
		TypedQuery<Branch> query = entityManager.createQuery(sql, Branch.class);
		query.setParameter("bank", bankId);
		
		branchs = query.getResultList();
		return branchs;
	}
}
