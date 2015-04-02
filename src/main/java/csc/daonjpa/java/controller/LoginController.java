package csc.daonjpa.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Customer;
import csc.daonjpa.java.service.CustomerService;

@Controller
@SessionAttributes({ "user", "roleuser" })
public class LoginController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String doLogin() {
		return "login";
	}

//	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
//	public ModelAndView checkLogin(@ModelAttribute("cus") Customer cus,
//			HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView md = new ModelAndView();
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		Customer customer = customerService.getCustomerByLoginId(username);
//		List<Account> listAccount = null;
//		if (customer != null && customer.getPassword().equals(password)) {
//			// success
//			HttpSession session = request.getSession();
//			session.setAttribute("user", customer);
//			
//			md = new ModelAndView("home");
//			listAccount = ((Customer) customer).getAccounts();
//			md.addObject("listAccount", listAccount);
//			return md;
//		} else {
//			// false
//			md = new ModelAndView("login");
//			md.addObject("message", "Wrong Username and Password");
//			return md;
//		}
//
//	}
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("cus") Customer cus,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView md = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer customer = customerService.getCustomerByLoginId(username);
		if (customer != null && customer.getPassword().equals(password)) {
			// success
			HttpSession session = request.getSession();
			session.setAttribute("user", customer);
			
			System.out.println(customer.getFirstName() + " " + customer.getLastName());
			md.setViewName("forward:/home");
			
			return md;
		} 
		md.setViewName("login");
		
		return md;
	}
	
	@RequestMapping( value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
}
