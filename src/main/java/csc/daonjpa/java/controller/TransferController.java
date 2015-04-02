package csc.daonjpa.java.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;
import csc.daonjpa.java.domain.Customer;
import csc.daonjpa.java.domain.LogTransaction;
import csc.daonjpa.java.service.AccountService;
import csc.daonjpa.java.service.TransferService;

@Controller
public class TransferController {

	@Autowired
	TransferService transferService;

	private List<Account> listAccount;

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	@RequestMapping(value = "/transferview", method = RequestMethod.GET)
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
		
		List<Bank> listBank = null;
		listAccount = ((Customer) cus).getAccounts();
		listBank = transferService.getListBank();
		md.addObject("listbank", listBank);
		md.addObject("listaccount", listAccount);
		return md;
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
		ModelAndView md = new ModelAndView("transfermoney");
		
		boolean recentAccountState = request.getParameter("recentAccount") != null;
		
		if (recentAccountState == true) {
			
		} else {
			
		}
		
		String accountname = request.getParameter("accountname").trim();
		long amount = Long.parseLong(request.getParameter("amount"));
		Date date = new Date();
		
		// SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss DD/MM/YY");
		long idbranch = Long.parseLong(request.getParameter("slbranch"));
		long idsend = Long.parseLong(request.getParameter("sendaccount"));
		Account account = transferService.checkAccount(accountname);
		if (account != null && idsend != account.getId()) {
			transferService.insertTransaction(amount, date, idbranch,
					account.getId(), idsend);
			md.addObject("message", "Transfer Successfully");
			return md;
		} else {
			md.addObject("message", "Transfer unseccessfull");
			return md;
		}

	}
/*	@RequestMapping(value = "/submitTransfer", method = RequestMethod.POST)
	public ModelAndView transfer(@ModelAttribute("log") LogTransaction log,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView md = new ModelAndView("transfermoney");
		
		String accountname = request.getParameter("accountname").trim();
		long amount = Long.parseLong(request.getParameter("amount"));
		Date date = new Date();
		
		// SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss DD/MM/YY");
		long idbranch = Long.parseLong(request.getParameter("slbranch"));
		long idsend = Long.parseLong(request.getParameter("sendaccount"));
		Account account = transferService.checkAccount(accountname);
		if (account != null && idsend != account.getId()) {
			transferService.insertTransaction(amount, date, idbranch,
					account.getId(), idsend);
			md.addObject("message", "Transfer Successfully");
			return md;
		} else {
			md.addObject("message", "Transfer unseccessfull");
			return md;
		}
		
	}
*/
}
