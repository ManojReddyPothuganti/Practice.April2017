package IMCS.trng.April2017.EmployeeAppSpringCore.EmployeeServiceInterface;

import java.sql.SQLException;
import java.util.List;

import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;



public interface EmployeeServiceInterface {
	boolean createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException, SQLException;
	Employee findEmployee(int empId) throws SQLException;
	List<Employee> findAllEmployees();
	boolean deleteEmployee(int empId) throws SQLException, InvalidEmployeeException;
	boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException, SQLException, InvalidEmployeeException;
	
 

}
