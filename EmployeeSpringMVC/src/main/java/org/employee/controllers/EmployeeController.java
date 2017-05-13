package org.employee.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.employee.validators.EmployeeValidator;
import org.employee.wrapper.EmployeeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import IMCS.trng.April2017.EmployeeAppSpringCore.EmployeeServiceInterface.EmployeeServiceInterface;
import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceInterface employeeService;
	
	@Autowired
	EmployeeValidator employeeValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(employeeValidator);
	}
	
	@RequestMapping(value="/createEmployee")
	public String createEmployee(Model model){
		model.addAttribute(new Employee());
		return "createEmployee";
	}
	
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute @Valid Employee employee,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(employee.getFirstName().length() + "is length of firstName");
			if(result.hasErrors()){
				modelAndView.setViewName("createEmployee");
				return modelAndView;
			}
		try {
			boolean flag=employeeService.createEmployee(employee);
			if (flag==true){
			modelAndView.addObject("message", "Employee created Successfully");
			}
			else{
				modelAndView.addObject("message", "Error creating the Employee");
			}
		} catch (EmployeeCreationException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message", "Error creating the Employee");
			e.printStackTrace();
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message", "Error creating the Employee");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message", "Error creating the Employee");
			e.printStackTrace();
		}
		
		modelAndView.setViewName("home");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/viewEmployee")
	public String viewEmployee(Model model){
		
		//model.addAttribute(new Employee());
		model.addAttribute("employee", new Employee());
		return "viewEmployee";
	}
	
	@RequestMapping(value="/viewEmployee",method=RequestMethod.POST)
	public ModelAndView viewEmployee(@RequestParam(value="id",required=true) String id){
		ModelAndView modelAndView = new ModelAndView();
		Employee employee;
		try {
			employee = employeeService.findEmployee(Integer.parseInt(id));
			if(employee ==null){
				modelAndView.addObject("message", "Employee not found with given Id");
				
			}
			else{
				
				
				modelAndView.addObject("employee", employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message", "Employee not found with given Id");
			e.printStackTrace();
		}
		
		modelAndView.setViewName("viewEmployee");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/viewUpdateEmployee",method=RequestMethod.POST)
	public ModelAndView viewUpdateEmployee(@RequestParam(value="id",required=true) String id){
		ModelAndView modelAndView = new ModelAndView();
		
		Employee employee;
		try {
			employee = employeeService.findEmployee(Integer.parseInt(id));
			if(employee ==null){
				modelAndView.addObject("message", "Employee not found with given Id");
				
			}
			else{
				modelAndView.addObject("employee", employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message", "Employee not found with given Id");
			e.printStackTrace();
		}
		
		modelAndView.setViewName("updateEmployee");
		return modelAndView;
	}
	
	@RequestMapping(value="/updateEmployee",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		try {
			//System.out.println(employee.getId());
			boolean flag=employeeService.updateEmployee(employee);
			if(flag==true){
			Map<String,Object> hm = new HashMap<String,Object>();
			hm.put("employee",employee);
			hm.put("message","Employee updated successfully ");
			
			modelAndView.addAllObjects(hm);
			}
			else{
				modelAndView.addObject("message","Error  Updating Employee , please check the salary field");
			}
			
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message","Error  Updating Employee , please check the salary field");
			e.printStackTrace();
		} catch (EmployeeCreationException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message","Error  Updating Employee , please check the salary field");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message","Error  Updating Employee , please check the salary field");
			e.printStackTrace();
		} catch (InvalidEmployeeException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message","Error  Updating Employee , please check the salary field");
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	
	
	@RequestMapping(value="/updateEmployee")
	public String updateEmployee(Model model){
		
		model.addAttribute(new Employee());
		return "updateEmployee";
	}
	
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		//System.out.println(id);
		//Employee employee;
		try {
			System.out.println(employee.getId());
			boolean flag=employeeService.deleteEmployee(employee.getId());
			if(flag==true){
				modelAndView.addObject("message", "Employee deleted Successfully of given id");
			}
			else{
				modelAndView.addObject("message", "Employee not found with given Id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			modelAndView.addObject("message", "Employee not found with given Id");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modelAndView.setViewName("updateEmployee");
		return modelAndView;
	}

}
