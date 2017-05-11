package IMCS.trng.April2017.EmployeeAppSpringCore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import imcs.training.april2017.EmployeeOperations.DAOInterface.EmployeeDaoInterface;
import imcs.training.april2017.EmployeeOperations.Implementations.EmployeeDaoImplementation;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

@Configuration
@ComponentScan(basePackages={"IMCS.trng.April2017.EmployeeAppSpringCore.*"})


public class ApplicationConfiguration {
		@Bean
		public EmployeeDaoInterface getDaoObject(){
			return new EmployeeDaoImplementation();
		}
		
		@Bean
		public Employee getEmployee(){
			return new Employee();
		}

	}
	
	

