package imcs.trng;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.training.april2017.EmployeeOperations.Implementations.EmployeeDBOperations;
import imcs.training.april2017.EmployeeOperations.Interfaces.EmployeeOperations;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

/**
 * Servlet implementation class ViewEmployeeServlet
 */
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/ViewEmployee.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeOperations employeeOperations = new EmployeeDBOperations();
		List<Employee> employees = new ArrayList<Employee>();
		boolean flag = false;
		if(request.getParameter("employeeId").equals("")){
			try {
				employees = employeeOperations.findAll();
				flag=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("EmployeeNotFound.html");
			}
		}
		else{


			try {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				Employee employee = employeeOperations.findEmployee(employeeId);
				if(employee==null){
					request.setAttribute("notFound",true);
					request.getRequestDispatcher("/ViewEmployee.jsp").forward(request,response);
				}
				else{


					employees.add(employee);
					flag=true;
				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("notFound",true);
				request.getRequestDispatcher("/ViewEmployee.jsp").forward(request,response);
			}catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("notFound",true);
				request.getRequestDispatcher("/ViewEmployee.jsp").forward(request,response);
			}
		}
		if(flag==true){
			request.setAttribute("employees",employees);
			request.getRequestDispatcher("/ViewEmployee.jsp").forward(request,response);
		}
	}

}
