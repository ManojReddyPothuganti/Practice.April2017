package imcs.trng;

import java.io.IOException;
import java.sql.SQLException;

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
		request.getRequestDispatcher("/ViewEmployee.html").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		EmployeeOperations employeeOperations = new EmployeeDBOperations();
		try {
			Employee employee = employeeOperations.findEmployee(employeeId);
			if(employee==null){
				response.sendRedirect("EmployeeNotFound.html");
			}
			else{
				request.setAttribute("id", employee.getId());
				request.setAttribute("firstName", employee.getFirstName());
				request.setAttribute("lastName", employee.getLastName());
				request.setAttribute("salary", employee.getSalary());
				request.setAttribute("address", employee.getAddress());
				request.setAttribute("gender", employee.getGender().toString());
				request.getRequestDispatcher("/ViewEmployeeDetails.jsp").forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			response.sendRedirect("EmployeeNotFound.html");
		}
	}

}
