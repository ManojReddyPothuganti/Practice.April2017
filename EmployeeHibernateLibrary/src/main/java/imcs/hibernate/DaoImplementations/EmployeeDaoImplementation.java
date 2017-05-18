package imcs.hibernate.DaoImplementations;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import imcs.hibernate.DaoInterfaces.EmployeeDaoInterface;
import imcs.hibernate.Exceptions.EmployeeCreationException;
import imcs.hibernate.Exceptions.InvalidEmployeeException;
import imcs.hibernate.Pojo.Employee;
import imcs.hibernate.beans.SalaryCount;
import imcs.hibernate.util.HibernateUtils;
import imcs.hibernate.util.SalaryCountResultTransformer;

public class EmployeeDaoImplementation implements EmployeeDaoInterface {

	SessionFactory sf;
	final static Logger logger = Logger.getLogger(EmployeeDaoImplementation.class);

	public EmployeeDaoImplementation() {
		sf = HibernateUtils.getSessionFactory();
	}


	public boolean save(Employee employee) throws EmployeeCreationException {
		// TODO Auto-generated method stub
		logger.debug("Executing EmployeeDaoImplementation::save API" + employee.getFirstName());
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(employee);
		}catch(Exception e){
			logger.error("failed to execute save method", e);
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	public Employee get(int id) throws SQLException {
		// TODO Auto-generated method stub
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, id);


		session.getTransaction().commit();
		session.close();

		return employee;

	}

	public List<Employee> getAll() throws SQLException {
		// TODO Auto-generated method stub
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		/*criteria.add(Restrictions.eq("firstName", "Raj"));
        criteria.add(Restrictions.ne("email", "raj@gmail.com"));
		 */
		List<Employee> employees = criteria.list();
		session.close();
		return employees;


	}

	public boolean delete(int id) throws SQLException, InvalidEmployeeException {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete Employee where id = :id";
		try{
			Query query = session.createQuery(hql).setParameter("id", id);
			query.executeUpdate();
		}catch(Exception e){
			logger.error("failed to execute delete method", e);
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	public boolean update(Employee employee) throws SQLException, InvalidEmployeeException {
		logger.debug("Executing EmployeeDaoImplementation::update API" + employee.getFirstName());
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.update(employee);
		}catch(Exception e){
			logger.error("failed to execute update method", e);
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> sort(String criteria) throws SQLException {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//String hql = "FROM Employee e ORDER BY "+ criteria;
		List<Employee> employees;
		try{
			employees = session.createCriteria(Employee.class)
					.addOrder(Order.desc(criteria))
					.list();

		}catch(Exception e){
			logger.error("failed to execute delete method", e);
			return null;
		}
		transaction.commit();
		session.close();
		return employees;
	}

	public List<SalaryCount> count(String criteria) throws SQLException {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select e.salary, count(salary) from Employee as e group by e.salary";
		List<SalaryCount> salaryCount;
		try{
			Query query = session.createQuery(hql);
			query.setResultTransformer(new SalaryCountResultTransformer());
			
			salaryCount = query.list();
			
		}catch(Exception e){
			logger.error("failed to execute delete method", e);
			System.out.println(e);
			return null;
		}
		transaction.commit();
		session.close();
		return salaryCount;
	}

}
