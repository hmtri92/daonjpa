package csc.daonjpa.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;
import csc.daonjpa.java.domain.Customer;
import csc.daonjpa.java.service.BankService;
import csc.daonjpa.java.service.TargetAccountService;

@Controller
public class TargetAccountController {
	
	@Autowired
	TargetAccountService targetService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	Branch branch;

	@RequestMapping (value = "/targetAccount", method = RequestMethod.GET)
	public ModelAndView targetAccount(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		
		Customer customer = (Customer) session.getAttribute("user");
		
		if (customer == null) {
			model.setViewName("login");
			return model;
		}
		
		List<Account> lstAccount = customer.getAccounts();
		List<Bank> lstBank = bankService.getListBank();
		
		model.addObject("listaccount", lstAccount);
		model.addObject("listBank", lstBank);
		model.setViewName("targetAccount");
		return model;
	}
}
