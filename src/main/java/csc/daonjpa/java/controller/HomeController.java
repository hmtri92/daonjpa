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

@Controller
public class HomeController {

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
