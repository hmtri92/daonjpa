package csc.daonjpa.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import csc.daonjpa.java.domain.Customer;
import csc.daonjpa.java.service.CustomerService;

public class HomeController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping( value = "/editCustomerInfo", method = RequestMethod.GET)
	public String edit(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
	   Customer customer=(Customer)session.getAttribute("user");
	   model.addAttribute("customer", customer);
		return "infoCustomer";
	}
}
