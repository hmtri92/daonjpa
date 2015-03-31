
package csc.daonjpa.java.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import csc.daonjpa.java.dao.AccountDAO;
import csc.daonjpa.java.domain.Account;

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
}
