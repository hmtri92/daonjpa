
package csc.daonjpa.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Customer;

/**
 * This controller handles account related actions
 * @author nvu3
 *
 */
@Controller
public class AccountController {
	/**
	 * Adds account to DB
	 * @param request
	 * @param model
	 * @return
	 */
/*	@RequestMapping(value = "/createAccount")
	public String addAccount(HttpServletRequest request, Model model) {
		// Read account info from request and save into Account object
		String accountType = request.getParameter("accountType");
		String accountName = request.getParameter("accountName");
		String accountNumber = request.getParameter("accountNumber");
		Account account = new Account(accountNumber, accountName, accountType, "123456765432", 0L);
		
		// Create an AccountDAO
		AccountDAO accountDAO = new AccountDAO();
		
		// Save account to DB
		accountDAO.addAccount(account);
		
		return "forward:/home.html";
	}*/
	
	@RequestMapping( value = "/home")
	public ModelAndView goHome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();
		
		Customer customer = (Customer)session.getAttribute("user");
		
		if (customer != null) {
			model.setViewName("home");
			List<Account> accounts = customer.getAccounts();
			model.addObject("listAccount", accounts);
			return model;
		}
		
		model.setViewName("login");
		return model;
	}
}
