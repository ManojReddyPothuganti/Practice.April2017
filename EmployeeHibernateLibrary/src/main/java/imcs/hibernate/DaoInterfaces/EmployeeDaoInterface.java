package imcs.hibernate.DaoInterfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import imcs.hibernate.Exceptions.*;
import imcs.hibernate.Pojo.Employee;
import imcs.hibernate.beans.SalaryCount;

public interface EmployeeDaoInterface {
	public boolean save(Employee employee) throws EmployeeCreationException;
	public Employee get(int id) throws SQLException;
	public List<Employee> getAll() throws SQLException;
	public boolean delete(int id) throws SQLException, InvalidEmployeeException;
	public boolean update(Employee employee) throws SQLException, InvalidEmployeeException;
	public List<Employee> sort(String criteria) throws SQLException;
	public List<SalaryCount> count(String criteria) throws SQLException;
	
	

}
