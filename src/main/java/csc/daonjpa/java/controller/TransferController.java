package csc.daonjpa.java.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;
import csc.daonjpa.java.domain.Customer;
import csc.daonjpa.java.domain.LogTransaction;
import csc.daonjpa.java.domain.TargetAccount;
import csc.daonjpa.java.service.AccountService;
import csc.daonjpa.java.service.BankService;
import csc.daonjpa.java.service.TargetAccountService;
import csc.daonjpa.java.service.TransferService;

@Controller
public class TransferController {

	@Autowired
	TransferService transferService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	TargetAccountService targetService;
	
	@Autowired
	AccountService accountService;

	private List<Account> listAccount;

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	@RequestMapping(value = "/transferview", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView transfer(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Customer cus = (Customer) session.getAttribute("user");
		ModelAndView md = new ModelAndView("transfermoney");
		
		// Check login
		if (cus == null) {
			md.setViewName("login");
			return md;
		}
		
		List<Bank> listBank = bankService.getListBank();
		listAccount = ((Customer) cus).getAccounts();
		
		md.addObject("listbank", listBank);
		md.addObject("listaccount", listAccount);
		return md;
	}
	
	@RequestMapping (value = "/getTargetByAccount", method = RequestMethod.POST)
	@ResponseBody
	public List<TargetAccount> getTargetByAccount(HttpServletRequest request, HttpServletResponse response) {
		long accountOwner = Long.parseLong(request.getParameter("idAccount"));
		
		List<TargetAccount> targets = targetService.getTargetByAccount(accountOwner);
		
		return targets;
	}

	@RequestMapping(value = "/ajaxGetbranch/{id}", method = RequestMethod.GET)
	public ModelAndView getBranchbybank(@PathVariable(value = "id") int id,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView md = new ModelAndView("ajaxGetbranch");
		List<Branch> listBranch = null;
		listBranch = transferService.getBracnchByBank(id);
		md.addObject("listbranch", listBranch);
		return md;
	}
	
	@RequestMapping(value = "/submitTransfer", method = RequestMethod.POST)
	public ModelAndView transfer(@ModelAttribute("log") LogTransaction log,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		
		boolean recentAccountState = request.getParameter("checkBox") != null;
		String message = "";
		
		if (recentAccountState == true) {
			message = transferInTarget(request, response);
		} else {
			message = transferNewAccount(request, response);
		}
		
		
		model.addObject("message", message);
		model.setViewName("forward:/transferview");
		return model;
		
	}
	
	private String transferInTarget(HttpServletRequest request, HttpServletResponse response) {
		long sendAccount_id = Long.parseLong(request.getParameter("sendaccount"));
		long amount = Long.parseLong(request.getParameter("amount"));
		long recentAccount_id = Long.parseLong(request.getParameter("recentAccount"));
		
		accountService.checkMoneyByAccount(sendAccount_id, amount);
		
		if (checkMoney(sendAccount_id, amount)) {
			
			TargetAccount recentAccount = targetService.getAccountNumber(recentAccount_id);
			
			transferService.sendAmount(sendAccount_id, recentAccount.getAccountNumber().getId(), 
					amount, recentAccount.getBranch().getId());
			return "Success";
		} else {
			return "Not enough money";
		}
	}
	
	private String transferNewAccount(HttpServletRequest request, HttpServletResponse response) {
		long sendAccount_id = Long.parseLong(request.getParameter("sendaccount"));
		long amount = Long.parseLong(request.getParameter("amount"));
		long recentAccount_id = Long.parseLong(request.getParameter("accountNumber"));
		int banch_id = Integer.parseInt(request.getParameter("branchlist"));
		
		if (checkMoney(sendAccount_id, amount)) {
			transferService.sendAmount(sendAccount_id, recentAccount_id, 
					amount, banch_id);
			return "Success";
		} else {
			return "Not enough money";
		}
	}
	
	private boolean checkMoney(long account, long amount) {
		return accountService.checkMoneyByAccount(account, amount);
	}
	
}
