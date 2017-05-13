package org.employee.wrapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

@Component
public class EmployeeWrapper {
	
	private ArrayList<Employee> employees;

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	

}
