package imcs.training.april2017.EmployeeOperations.Implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Interfaces.EmployeeOperations;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

public class EmployeeArrayOperations implements EmployeeOperations{

    private Employee[] employees;
    @SuppressWarnings("unused")
	private int length;
    private int size;

    public EmployeeArrayOperations(int length) {
        employees = new Employee[length];
    }

    

	public boolean createEmployee(Employee employee) throws EmployeeCreationException, InvalidSalaryException {
		 validateData(employee);
		
        if (size == employees.length) {
            resizeEmployees();
        }

        employees[size++] = employee;
        return true;
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



	private void resizeEmployees() {
        employees = Arrays.copyOf(employees, size * 2);
    }

    public Employee findEmployee(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == empId) {
                return employees[i];
            }
        }
        return null;
    }

    public List<Employee> findAll() {
        Employee[] allEmployees = Arrays.copyOfRange(employees, 0, size);
        List<Employee> employees = new ArrayList<Employee>(Arrays.asList(allEmployees));
        return employees;
    }

    public boolean deleteEmployee(int empId) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {

            if (employees[i].getId() == empId) {
                employees[i] = null;                                    //delete by making it null
                for (int j = i; j < size-1; j++) {
                    employees[j] = employees[j + 1];                       // shift
                }
                flag = true;
                employees[size--] = null;
            }
        }
        return flag;
    }

    public boolean updateEmployee(Employee employee) throws InvalidSalaryException, EmployeeCreationException {
    	
    	validateData(employee);
    	
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == employee.getId()) {
            	if(Math.abs((employees[i].getSalary()+employee.getSalary()) - employees[i].getSalary()) > 5000 ){
            		throw new InvalidSalaryException("Salary cannot be incremented beyond 5000$");
            	}
                employees[i] = employee;
                flag = true;
            }
        }
        return flag;
    }


    public double displayHRA(int empId) {
        double hra = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == empId) {
                hra = employees[i].calculateHRA();
                break;
            }
        }

        return hra;
    }

    public Double calculateGrossSal(int empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == empId) {
                return employees[i].calculateGrossSal();
            }
        }
        return null;
    }



	public List<Employee> SortByName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Employee> sortBySalary() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
