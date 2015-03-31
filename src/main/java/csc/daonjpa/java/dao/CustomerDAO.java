package csc.daonjpa.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;
import csc.daonjpa.java.domain.Customer;

@Repository("customerDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Customer getCustomerByLoginId(String loginId) {
		return entityManager.find(Customer.class, loginId);
	}
	
	@Transactional
	public Customer updateCustomerInfoById(Customer cus)
	{
		Customer customer=entityManager.find(Customer.class, cus.getLoginId());
		customer.setAddress(cus.getAddress());
		customer.setPassword(cus.getPassword());
		customer.setPhone(cus.getPhone());
		customer.setFirstName(cus.getFirstName());
		customer.setLastName(cus.getLastName());
		/* Query query = entityManager.createQuery(
			      "UPDATE Customer c SET c.password = ?1, c.firstName = ?2 where c.loginId=?3");
		 query.setParameter(1, cus.getPassword());
		 query.setParameter(2, cus.getFirstName());
		 query.setParameter(3, cus.getLoginId());
			int updateCount = query.executeUpdate();
			return updateCount;*/
		return customer;
	}
	
	
	
}
