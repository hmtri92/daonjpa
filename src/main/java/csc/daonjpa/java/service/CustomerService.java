package csc.daonjpa.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.daonjpa.java.dao.CustomerDAO;
import csc.daonjpa.java.domain.Customer;

@Service("customerService")
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;
	
	public Customer getCustomerByLoginId(String loginId) {
		return customerDAO.getCustomerByLoginId(loginId);
	}
	
	public Customer updateCustomerInfo(Customer cus)
	{
		 return customerDAO.updateCustomerInfoById(cus);
	}
	
	
}
