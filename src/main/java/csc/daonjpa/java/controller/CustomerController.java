package csc.daonjpa.java.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import csc.daonjpa.java.domain.Account;
import csc.daonjpa.java.domain.Bank;
import csc.daonjpa.java.domain.Branch;
import csc.daonjpa.java.domain.Customer;
import csc.daonjpa.java.service.CustomerService;

@Controller
public class CustomerController {
	
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
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("customer") Customer cus,
			HttpServletRequest request, HttpServletResponse response) {
			ModelAndView md=new ModelAndView("home");
			Customer customer=customerService.updateCustomerInfo(cus);
			if(customer!=null){
				
				HttpSession session=request.getSession();
				session.setAttribute("user",customer);
				return md;
			}
			else
			{
				md =new ModelAndView("infoCustomer");
			return md;
			}
	}
}
