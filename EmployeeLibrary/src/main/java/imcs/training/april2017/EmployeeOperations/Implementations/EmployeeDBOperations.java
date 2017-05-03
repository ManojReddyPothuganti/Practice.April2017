package imcs.training.april2017.EmployeeOperations.Implementations;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import imcs.training.april2017.EmployeeOperations.DAOInterface.EmployeeDaoInterface;
import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Interfaces.EmployeeOperations;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

public class EmployeeDBOperations implements EmployeeOperations{

    
    private EmployeeDaoInterface employeeDaoImplementation;

    public EmployeeDBOperations() {
    	
    	employeeDaoImplementation = new EmployeeDaoImplementation();
    	
    }

    

	public boolean createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException {
		 validateData(employee);
		
        boolean status=employeeDaoImplementation.save(employee);
        if(status ==false){
        	throw new EmployeeCreationException("Error in creating the employee");
        }
        return status;
    }

    private void validateData(Employee employee) throws EmployeeCreationException, InvalidSalaryException {
		// TODO Auto-generated method stub
    	
    		if(employee.getId() <= 0){
    			throw new EmployeeCreationException("Invalid id please enter the valid positive id");
    		}
    		if(employee.getFirstName() ==null || employee.getFirstName().equals("")){
    			throw new EmployeeCreationException("Invalid first name, Please enter the valid first name ");
    		}
    		if(employee.getLastName() ==null || employee.getLastName().equals("")){
    			throw new EmployeeCreationException("Invalid last name, Please enter the valid last name ");
    		}
    		if(employee.getSalary() <0 || employee.getSalary() > 100000){
    			throw new InvalidSalaryException("Invalid salary, Please enter the salary in range of 1 and 100000  ");
    		}
    		
    		
    			
	}



    public Employee findEmployee(int empId) throws SQLException {
        Employee employee = employeeDaoImplementation.get(empId);
        return employee;
    }

    public List<Employee> findAll() throws SQLException {
    	List<Employee> employees = employeeDaoImplementation.getAll();
        return employees;
    }

    public boolean deleteEmployee(int empId) throws SQLException, InvalidEmployeeException {
        boolean flag = employeeDaoImplementation.delete(empId);
        
        return flag;
    }

    public boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException, SQLException, InvalidEmployeeException {
    	
    	validateData(employee);
        boolean flag = employeeDaoImplementation.update(employee);
        return flag;
    }


    public double displayHRA(int empId) throws SQLException {
        //double hra = 0;
        Employee employee =employeeDaoImplementation.get(empId);
        if(employee==null){
        	return 0.0;
        }
        return employee.calculateHRA();
    }

    public Double calculateGrossSal(int empId) throws SQLException {
    	Employee employee =employeeDaoImplementation.get(empId);
        if(employee==null){
        	return 0.0;
        }
        return employee.calculateGrossSal();
    }



	public List<Employee> SortByName() throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> sortEmployees=employeeDaoImplementation.sort("firstName");
		return sortEmployees;
	}



	public List<Employee> sortBySalary() throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> sortEmployees=employeeDaoImplementation.sort("salary");
		return sortEmployees;
		
	}



	public Set<Employee> uniqueEmployees() throws SQLException {
		// TODO Auto-generated method stub
		Set<Employee> unique = new HashSet<Employee>(employeeDaoImplementation.getAll());
		return unique;
	}
	
	public Map<Double,Integer> salaryCount() throws SQLException{
		Map<Double,Integer> count = employeeDaoImplementation.count("salary");
		
		return count;
	}
    
    
}
