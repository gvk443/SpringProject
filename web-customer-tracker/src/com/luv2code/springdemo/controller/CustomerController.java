package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	
	
	// need to inject the Customer Service
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers( Model theModel )
	{
		
		System.out.println(">>>>. INSIDE OF POST MAPPING VERSION");
		
		
		// get customers from the service 
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		
		// add the customers to the model
		
		theModel.addAttribute("customers", theCustomers  );
		
		
		return "list-customers";
		
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd( Model theModel )
	{
		
		// create model attribute to bind form data 
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer( @ModelAttribute("customer") Customer theCustomer )
	{
		
		// save the customer using our service 
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)
	{
		
		// get the customer from service which inturn gets from the database
		
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to form
		
		
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId	)
	{
	
		// delete the customer
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
		
	}
	

}
