package com.mas.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mas.domin.Contact;

import com.mas.service.CustomerServiceImpl;

@Controller
public class ContectController {
	private static Logger logger = LogManager.getLogger(ContectController.class);

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	private String parameter;

	@RequestMapping("/welcome")
	public String showForm(Model model) {
		logger.info("Hello from Log4j 2 - num : {}");
		Contact contact = new Contact();
		model.addAttribute("ContactDel", contact);
		return "welcome";

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/submitform")
	public String SaveCustomer(@ModelAttribute("ContactDel") Contact contact, RedirectAttributes attribute) {
		logger.info("{ }",() -> customerServiceImpl.saveCustomerDetails(contact));
		String msg = null;
		
		Boolean saveCustomerDetails = customerServiceImpl.saveCustomerDetails(contact);
		
		if (saveCustomerDetails) {
			attribute.addFlashAttribute("msg", "Record saved");
		} else {
			attribute.addFlashAttribute("msg", "Not saved");
		}
		
		return "redirect:/postRedirectGetPattern";

	}

	@RequestMapping("/viewAllData")
	public List<Contact> findAllCustomerDetails(Model model) {
		List<Contact> allCustomerDetails = customerServiceImpl.getAllCustomerDetails();
		logger.info("view All Data Info ::" + allCustomerDetails);
		model.addAttribute("contacts", allCustomerDetails);
		return allCustomerDetails;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public String editCustomerDetails(HttpServletRequest hsr, RedirectAttributes attributes,Model model) {
		
	 String customer_Id= hsr.getParameter("customer_id");
		 Contact contact = customerServiceImpl.editCustomerDetails(customer_Id);

		 logger.info("edit Data Info ::"+contact); 
	
			  model.addAttribute("ContactDel",contact);
			 //attributes.addFlashAttribute("ContactWithData", editCustomerDetails); }
		return "welcome";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String delectCustomerDetails(HttpServletRequest hsr,RedirectAttributes attributes) {
		String customer_Id = hsr.getParameter("customer_id");
		Integer details = customerServiceImpl.delectCustomerDetails(customer_Id);
		logger.info("delete Data Info ::" + details);
		if (details == 1) {
			attributes.addFlashAttribute("msg","Recoad Delected");
		} else {
			attributes.addFlashAttribute("msg","Not Delected");
		}
		return "redirect:/viewAllData";

	}

	@RequestMapping(value = "/postRedirectGetPattern", method = RequestMethod.GET)
	public String postRedirectGetPattern(Model model) {
		model.addAttribute("ContactDel", new Contact());
		return "welcome";

	}

}
