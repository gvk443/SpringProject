package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController 
{
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService)
	{
		employeeService=  theEmployeeService; 
	}
	
	// add a mapping for "/list"
	
	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{	
		// get employees from database
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		 
		return "employees/list-employees";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		// create model attribute to bind form data
		
		Employee theEmployee = new Employee();
		
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
	}
	
	@PostMapping("save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
	{
		// save the employeee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submission
		
		return"redirect:/employees/list";
		
	}
	
	
	
	

}
