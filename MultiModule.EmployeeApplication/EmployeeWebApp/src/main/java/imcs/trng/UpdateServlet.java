package imcs.trng;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Implementations.EmployeeDBOperations;
import imcs.training.april2017.EmployeeOperations.Interfaces.EmployeeOperations;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeOperations employeeOperations = new EmployeeDBOperations();
		String action = request.getParameter("action");
		Employee employee = null;
		if(action.equals("search")){


			try {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				employee = employeeOperations.findEmployee(employeeId);
				if(employee==null){
					request.setAttribute("notFound",true);
					request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
				}
				else{


					request.setAttribute("employee",employee);
					request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);

				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				request.setAttribute("notFound",true);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				request.setAttribute("notFound",true);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			}

		}
		if(action.equals("update")){
			System.out.println("Entered the update condition");
			int empId = Integer.parseInt(request.getParameter("employeeId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			double salary = Double.parseDouble(request.getParameter("salary"));
			String address=request.getParameter("address");
			String gender = null;
			try {
				gender = employeeOperations.findEmployee(empId).getGender().toString().toLowerCase();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int gender1=0;
			if(gender.equals("male")){
				gender1 = 1;
			}else{
				gender1 = 2;
			}
			 employee = new Employee(empId,firstName,lastName,salary,address,gender1);
			
			
			try {
				boolean flag = employeeOperations.updateEmployee(employee);
				if(flag == true){
					request.setAttribute("updated", true);
					request.setAttribute("employee", employee);
					request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
				}
				else{
					request.setAttribute("updated", false);
					request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
				}
			} catch (EmployeeCreationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("updated", false);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			} catch (InvalidSalaryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("updated", false);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("updated", false);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			} catch (InvalidEmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("updated", false);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			}

		}
	if(action.equals("delete")){
		int empId = Integer.parseInt(request.getParameter("employeeId"));
		try {
			boolean flag = employeeOperations.deleteEmployee(empId);
			if(flag==true){
				request.setAttribute("deleted", true);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			}else{
				request.setAttribute("deleted", false);
				request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("deleted", false);
			request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
		} catch (InvalidEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("deleted", false);
			request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
		}
		
	}
		
	}
}
