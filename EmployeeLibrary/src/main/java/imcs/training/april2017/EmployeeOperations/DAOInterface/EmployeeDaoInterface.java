package imcs.training.april2017.EmployeeOperations.DAOInterface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

public interface EmployeeDaoInterface {
	public boolean save(Employee employee) throws EmployeeCreationException;
	public Employee get(int id) throws SQLException;
	public List<Employee> getAll() throws SQLException;
	public boolean delete(int id) throws SQLException, InvalidEmployeeException;
	public boolean update(Employee employee) throws SQLException, InvalidEmployeeException;
	public List<Employee> sort(String criteria) throws SQLException;
	public Map<Double,Integer> count(String criteria) throws SQLException;
	
	

}
