package imcs.hibernate.operations;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import imcs.hibernate.DaoImplementations.EmployeeDaoImplementation;
import imcs.hibernate.DaoInterfaces.EmployeeDaoInterface;
import imcs.hibernate.Exceptions.EmployeeCreationException;
import imcs.hibernate.Exceptions.InvalidEmployeeException;
import imcs.hibernate.Exceptions.InvalidSalaryException;
import imcs.hibernate.Pojo.Employee;
import imcs.hibernate.beans.SalaryCount;


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
	
	public Map<Double,Long> salaryCount() throws SQLException{
		List<SalaryCount> salaryCount = employeeDaoImplementation.count("salary");
		Map<Double,Long> salaryCountResults = new HashMap<Double,Long>();
		
		for(SalaryCount count: salaryCount ){
			salaryCountResults.put(count.getSalary(), (long) count.getCount());
		}
		
		return salaryCountResults;
	}

    
}
