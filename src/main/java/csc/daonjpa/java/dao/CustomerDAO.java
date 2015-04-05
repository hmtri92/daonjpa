package csc.daonjpa.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import csc.daonjpa.java.domain.Customer;

@Repository("customerDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerDAO {

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * Get Customer by id
	 */
	@Transactional
	public Customer getCustomerByLoginId(String loginId) {
		return entityManager.find(Customer.class, loginId);
	}

	/*
	 * Update infomation of Customer
	 */
	@Transactional
	public Customer updateCustomerInfoById(Customer cus) {
		Customer customer = entityManager.find(Customer.class, cus.getLoginId());
		customer.setAddress(cus.getAddress());
		customer.setPassword(cus.getNewPassword());
		customer.setPhone(cus.getPhone());
		customer.setFirstName(cus.getFirstName());
		customer.setLastName(cus.getLastName());
		return customer;
	}
	
	/*
	 * Create customer
	 */
	@Transactional
	public boolean createCustomer(Customer customer) {
		try {
			entityManager.persist(customer);
			return true;			
		} catch (Exception e) {
			return false;
		}
	}

}
