package csc.daonjpa.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;
import csc.daonjpa.java.domain.Customer;
import csc.daonjpa.java.service.AccountService;
import csc.daonjpa.java.service.BankService;
import csc.daonjpa.java.service.BranchService;
import csc.daonjpa.java.service.TargetAccountService;

@Controller
public class TargetAccountController {
	
	@Autowired
	TargetAccountService targetService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	AccountService accountService;

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
	
	@RequestMapping (value = "/getBranch", method = RequestMethod.POST)
	@ResponseBody
	public List<Branch> getListBranch(HttpServletRequest request, HttpServletResponse response) {
		int idBank = Integer.parseInt(request.getParameter("idBank"));
		
		List<Branch> branchs = branchService.getBranchBy(idBank);
		
		return branchs;
	}
	
	@RequestMapping (value = "/checkName", method = RequestMethod.POST)
	@ResponseBody
	public String chekAccount(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("idAccount"));
		return accountService.getNameById(id);
	}
	
	@RequestMapping (value = "/registerTargetAccount", method = RequestMethod.POST)
	public ModelAndView registerTargetAccount(HttpServletRequest request, HttpServletResponse response) {
		String accountOwner = request.getParameter("sendaccount");
		String accountNumber = request.getParameter("accountNumber");
		String nameTarget = request.getParameter("nameTarget");
		int bank = Integer.parseInt(request.getParameter("banklist"));
		int branch = Integer.parseInt(request.getParameter("branchlist"));
		
		boolean result = targetService.addNewTarget(accountOwner, accountNumber, nameTarget, bank, branch);
		
		ModelAndView model = new ModelAndView("home");
		if (result) {
			return model;
		} else {
			model.setViewName("forward:/targetAccount");
		}
		return model;
	}
 
}
