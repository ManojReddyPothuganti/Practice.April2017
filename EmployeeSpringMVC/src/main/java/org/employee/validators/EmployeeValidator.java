package org.employee.validators;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

@Component
public class EmployeeValidator implements Validator {
	
	public boolean supports(Class<?> claz) {
		return Employee.class.equals(claz);
	}

	public void validate(Object arg0, Errors errors) {
		Employee employee = (Employee) arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "employee.firstName.error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "employee.lastName.error");
		ValidationUtils.rejectIfEmpty(errors, "salary", "employee.salary.error","Please enter the salary , salary must be a number");
		ValidationUtils.rejectIfEmpty(errors, "address", "employee.address.error");
		ValidationUtils.rejectIfEmpty(errors, "gender", "employee.gender.error");
	}

}
