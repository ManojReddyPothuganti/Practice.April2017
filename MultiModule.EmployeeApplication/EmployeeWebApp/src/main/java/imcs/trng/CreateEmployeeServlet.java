package imcs.trng;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Implementations.EmployeeDBOperations;
import imcs.training.april2017.EmployeeOperations.Interfaces.EmployeeOperations;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

/**
 * Servlet implementation class CreateEmployeeServlet
 */
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/CreateEmployee.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//int empId = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String address=request.getParameter("address");
		String gender = request.getParameter("gender");
		int gender1=0;
		if(gender.equals("m")){
			gender1 = 1;
		}else{
			gender1 = 2;
		}
		Employee employee = new Employee(firstName,lastName,salary,address,gender1);
		EmployeeOperations employeeOperations = new EmployeeDBOperations();
		System.out.println(employeeOperations);
		try {
			boolean flag = employeeOperations.createEmployee(employee);
			if(flag == true){
				request.setAttribute("created", true);
				request.getRequestDispatcher("/home.html").forward(request,response);
			}
			else{
				request.setAttribute("created", false);
				response.sendRedirect("viewemployee.html");
			}
		} catch (EmployeeCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("errorCreatingEmployee.html");
		} catch (InvalidSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("errorCreatingEmployee.html");
		}
	}

}
