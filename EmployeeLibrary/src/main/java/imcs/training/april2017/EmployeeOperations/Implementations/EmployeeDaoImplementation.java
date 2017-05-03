package imcs.training.april2017.EmployeeOperations.Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import imcs.training.april2017.EmployeeOperations.Pojo.Employee.Gender;
import imcs.training.april2017.EmployeeOperations.Connection.ConnectionManager;
import imcs.training.april2017.EmployeeOperations.DAOInterface.EmployeeDaoInterface;
import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

public class EmployeeDaoImplementation implements EmployeeDaoInterface {
	

	@Override
	public boolean save(Employee employee) throws EmployeeCreationException {
		// TODO Auto-generated method stub
		
		String query = "Insert into Employee (id,firstName,lastName,salary,address,gender,flag) values (?,?,?,?,?,?,?)";
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1,employee.getId());
			ps.setString(2, employee.getFirstName());
			ps.setString(3,employee.getLastName());
			ps.setDouble(4, employee.getSalary());
			ps.setString(5,employee.getAddress());
			ps.setString(6,employee.getGender().toString());
			ps.setInt(7, 1);
			if(ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
		}
		catch(SQLException e){
			throw new EmployeeCreationException(e + " Problem in creating the Employee");
		}
		
	}

	@Override
	public Employee get(int id) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement statement = connection.prepareStatement("select id, firstName, lastName,salary,address,gender from Employee where id = ? and flag= ? ");
	        statement.setInt(1, id);
	        statement.setInt(2, 1);
	        ResultSet resultSet = statement.executeQuery();
	        //use resultset
	        if (resultSet.next()) {
	            Employee employee = new Employee();
	            employee.setId(resultSet.getInt("id"));
	            employee.setFirstName(resultSet.getString("firstName"));
	            employee.setLastName(resultSet.getString("lastName"));
	            employee.setSalary(resultSet.getDouble("salary"));
	            
	            employee.setAddress(resultSet.getString("address"));
	            employee.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
	            return employee;
	        }
		}
		return null;
	}

	@Override
	public List<Employee> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement statement = connection.prepareStatement("select id, firstName, lastName,salary,address,gender from Employee where flag=?");
	        statement.setInt(1,1);
	        ResultSet resultSet = statement.executeQuery();
	        
	        //use resultset
	        while (resultSet.next()) {
	            Employee employee = new Employee();
	            employee.setId(resultSet.getInt("id"));
	            employee.setFirstName(resultSet.getString("firstName"));
	            employee.setLastName(resultSet.getString("lastName"));
	            employee.setSalary(resultSet.getDouble("salary"));
	            
	            employee.setAddress(resultSet.getString("address"));
	            employee.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
	            employeeList.add(employee);
	            
	        }
		}  
		return employeeList;
	}
		

	@Override
	public boolean delete(int id) throws SQLException, InvalidEmployeeException {
		// TODO Auto-generated method stub
		int status;
		try(Connection connection=ConnectionManager.getConnection();){
		Employee employee = get(id);
		if(employee == null){
			throw new InvalidEmployeeException("Employee with specified id doesnt exist"+ id);
		}
		PreparedStatement statement = connection.prepareStatement("update Employee set flag = ? where id = ?");
		statement.setInt(1, 0);
		statement.setInt(2, id);
		status=statement.executeUpdate();
		
	}
		if(status > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Employee employee) throws SQLException, InvalidEmployeeException {
		// TODO Auto-generated method stub
		int status;
		try(Connection connection=ConnectionManager.getConnection();){
			Employee employee1=get(employee.getId());
			if(employee1==null){
				throw new InvalidEmployeeException("Employee with specified id doesnt exist"+ employee.getId()); 
			}
			PreparedStatement ps=connection.prepareStatement("update Employee set firstName=?,lastName=?,salary=?,address=?,gender=? where id=? ");
			
			ps.setString(1, employee.getFirstName());
			ps.setString(2,employee.getLastName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4,employee.getAddress());
			ps.setString(5,employee.getGender().toString());
			ps.setInt(6,employee.getId());
			status=ps.executeUpdate();
		}
		if(status>0){
			return true;
		}
		
		return false;
	}

	@Override
	public List<Employee> sort(String criteria) throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement statement = connection.prepareStatement("select id, firstName, lastName,salary,address,gender from Employee where flag=? order by "+ criteria.toLowerCase());
	        statement.setInt(1,1);
	        ResultSet resultSet = statement.executeQuery();
	        
	        //use resultset
	        while (resultSet.next()) {
	            Employee employee = new Employee();
	            employee.setId(resultSet.getInt("id"));
	            employee.setFirstName(resultSet.getString("firstName"));
	            employee.setLastName(resultSet.getString("lastName"));
	            employee.setSalary(resultSet.getDouble("salary"));
	            
	            employee.setAddress(resultSet.getString("address"));
	            employee.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
	            employeeList.add(employee);
	            
	        }
		}  
		return employeeList;
	}

	@Override
	public Map<Double, Integer> count(String criteria) throws SQLException {
		// TODO Auto-generated method stub
		Map<Double,Integer> employeeMap =new HashMap<Double,Integer>();
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement statement = connection.prepareStatement("select "+ criteria + ",count("+criteria+") from Employee where flag=? group by "+ criteria.toLowerCase());
	        statement.setInt(1,1);
	        ResultSet resultSet = statement.executeQuery();
	        
	        //use resultset
	        while (resultSet.next()) {
	            	            
	            employeeMap.put(resultSet.getDouble("salary"),resultSet.getInt(2));
	            
	        }
		}  
		return employeeMap;
		
	}

}
