package IMCS.trng.April2017.EmployeeAppSpringCore.EmployeeServiceImplementation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import IMCS.trng.April2017.EmployeeAppSpringCore.EmployeeRepository.EmployeeRepositoryInterface;
import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Pojo.*;
import IMCS.trng.April2017.EmployeeAppSpringCore.EmployeeServiceInterface.EmployeeServiceInterface;


@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface {
	@Autowired
	@Qualifier("EmployeeCollectionRepository")
	EmployeeRepositoryInterface employeeRepository;
	
	
//	public EmployeeServiceImplementation(EmployeeRepositoryInterface employeeRepository){
//		this.employeeRepository = employeeRepository;
//	}

	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		try {
			System.out.println("find all employees called :" + employeeRepository.findAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public boolean createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException, SQLException {
		// TODO Auto-generated method stub
		employeeRepository.findAll();
		return false;
	}


	public Employee findEmployee(int empId) throws SQLException {
		// TODO Auto-generated method stub
		employeeRepository.findEmployee(empId);
		return null;
	}


	public boolean deleteEmployee(int empId) throws SQLException, InvalidEmployeeException {
		// TODO Auto-generated method stub
		employeeRepository.deleteEmployee(empId);
		return false;
	}


	public boolean updateEmployee(Employee employee)
			throws InvalidSalaryException, EmployeeCreationException, SQLException, InvalidEmployeeException {
		// TODO Auto-generated method stub
		employeeRepository.updateEmployee(employee);
		return false;
	}


	
	
	

}
