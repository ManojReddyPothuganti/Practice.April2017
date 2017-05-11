package IMCS.trng.April2017.EmployeeAppSpringCore.EmployeeRepository;

import java.sql.SQLException;
import java.util.List;
//import IMCS.trng.April2017.EmployeeAppSpringCore.beans.Employee;
import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;


public interface EmployeeRepositoryInterface {

    boolean createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException;

    Employee findEmployee(int empId) throws SQLException;

    List<Employee> findAll() throws SQLException;

    boolean deleteEmployee(int empId) throws SQLException, InvalidEmployeeException;

    boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException, SQLException, InvalidEmployeeException;

    double displayHRA(int empId) throws SQLException;

    Double calculateGrossSal(int empId) throws SQLException;

	List<Employee> SortByName() throws SQLException;

	List<Employee> sortBySalary() throws SQLException;



	
}
