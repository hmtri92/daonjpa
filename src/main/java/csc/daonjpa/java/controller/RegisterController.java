package csc.daonjpa.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Customer;

@Controller
public class RegisterController {
	
	@RequestMapping (value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		Customer customer = new Customer();
		
		ModelAndView model = new ModelAndView("register");
		model.addObject("customer", customer);
		
		return model;
	}
	
}
