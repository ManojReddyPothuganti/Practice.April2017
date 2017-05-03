package imcs.training.april2017.EmployeeApplication.MainApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


import imcs.training.april2017.EmployeeApplication.Util.EmployeeUtil;
import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidEmployeeException;
import imcs.training.april2017.EmployeeOperations.Exceptions.InvalidSalaryException;
import imcs.training.april2017.EmployeeOperations.Implementations.EmployeeCollectionOperations;
import imcs.training.april2017.EmployeeOperations.Implementations.EmployeeDBOperations;
import imcs.training.april2017.EmployeeOperations.Interfaces.EmployeeOperations;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee.Gender;


// Comment line numbers 24 to 261 to run the application on arrays.
// COuld not able to integrate changes with existing system because both contain some different functions. So some of given operations doesn't work with arrays.

public class EmployeeApplication {

    private EmployeeOperations employeeOperations;
    public EmployeeApplication(){
    	employeeOperations=new EmployeeCollectionOperations();
    	//comment line 27 and uncomment line 29 to run program using JDBC.
    	//employeeOperations=new EmployeeDBOperations();
    }
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        EmployeeApplication employeeApplication = new EmployeeApplication();
        
        System.out.println("************Employee System**********");
        
               
        int choice = 0;
        @SuppressWarnings("unused")
		int operations=0;
        boolean flag=true;
        while(flag==true){
        	try{
        		choice = EmployeeUtil.chooseOperation();
        		
        	}
        	catch(InputMismatchException exception){
        		System.out.println(exception + " Please enter the valid choice");
        		continue;
        		
        	}
            switch (choice) {
                case 1:
                	
                	try{
                		employeeApplication.add();
                		operations=1;
                	}
                	catch(EmployeeCreationException e){
                		System.out.println(e + "  Problem in adding the employee,Please check the data given");
                	}
                	catch(InvalidSalaryException e){
                		System.out.println(e + "  Problem in adding the employee,Please check the data given");
                	}
                    break;
                case 2:
                	operations=1;
                    employeeApplication.display();
                    break;
                case 3:
                	operations=1;
                    employeeApplication.displayAll();
                    break;
                case 4:
                	
                	try{
                		employeeApplication.update();operations=1;
                	}
                	catch(EmployeeCreationException e){
                		System.out.println(e + " problem updating the data");
                	}
                	catch(InvalidSalaryException e){
                		System.out.println(e + " problem updating the data");
                	}
                	catch(InvalidEmployeeException e){
                		System.out.println(e +" problem updating employee,Id doesn't exist");
                	}
                    break;
                case 5:
                	operations=1;
                	try{
                		employeeApplication.delete();
                	}
                	catch(InvalidEmployeeException e){
                		System.out.println(e +" Problem deleting the employee");
                	}
                    break;
                case 6:
                	operations=1;
                    employeeApplication.displayHRA();
                    break;
                case 7:
                	operations=1;
                    employeeApplication.displayGrossSalary();
                    break;
                case 8:
                	operations = 1;
                	employeeApplication.sortData();
                	break;
               
                case 9:
                	operations = 1;
                	employeeApplication.getUniqueEmployees();
                	break;
                case 10:
                	operations = 1;
                	employeeApplication.getSalaryCount();
                	break;
                case 11:
                	
                	flag=false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } 

        scanner.close();
    }
    
    
	

	private void displayGrossSalary() throws SQLException {
        System.out.println("Enter the employee id to calculte gross salary of employee");
        try{
        	int empNo = Integer.parseInt(scanner.next());
        	System.out.println("Gross Salary of employee id " + empNo + " is : " + employeeOperations.calculateGrossSal(empNo));
        }
        catch(InputMismatchException e){
        	System.out.println( e + " Please enter the valid id");
        }
        
        
    }

    private void displayHRA() throws SQLException {
        System.out.println("Enter the employee id to calculte hra of employee");
        try{
        	int number = Integer.parseInt(scanner.next());
        	System.out.println("Hra of employee id " + number + " is : " + employeeOperations.displayHRA(number));
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter the valid id");
        }
        
        
    }

    private void delete() throws SQLException, InvalidEmployeeException {
        System.out.println("Enter the employee id to delete :");
        try{
        	int empId = scanner.nextInt();
        
        boolean flag = employeeOperations.deleteEmployee(empId);
        if (flag) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("No employee found with given number : " + empId);
        }
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter the valid id");
        }
    }

    private void update() throws EmployeeCreationException, InvalidSalaryException, SQLException, InvalidEmployeeException {
        System.out.println("Enter Employees data for update:");
        Employee employee = EmployeeUtil.readEmployee();
        employeeOperations.updateEmployee(employee);
    }

    private void displayAll() throws SQLException {
        System.out.println("Employees in the system are :");
        List<Employee> employees = employeeOperations.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void display() throws SQLException {
        System.out.println("Enter the employee id to view employee info :");
        try{
        	int empId = scanner.nextInt();
        	Employee employee = employeeOperations.findEmployee(empId);
        	System.out.println(employee);
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter valid data");
        }
    }

    private void add() throws EmployeeCreationException, InvalidSalaryException {
        Employee employee = EmployeeUtil.readEmployee();
        boolean flag=employeeOperations.createEmployee(employee);
        if(flag==true){
        	System.out.println("Employee created successfully");
        }
    }

    private void sortData() throws SQLException {
		// TODO Auto-generated method stub
    	boolean flag=true;
    	while(flag==true){
    		int sort=EmployeeUtil.sortDataUtil();
    	if(sort ==1 || sort ==2){
    		flag=false;
    		if(sort == 1){
    			displayList(employeeOperations.SortByName());
    		}
    	
    		else{
    			displayList(employeeOperations.sortBySalary());
    		}
    	}
    }
    	
		
	}



	private void displayList(List<Employee> sortByName) {
		// TODO Auto-generated method stub
		for(Employee e : sortByName){
			System.out.println(e.getId() +"  "+e.getFirstName()+"  "+e.getSalary());
		}
		
	}
	
	private void getUniqueEmployees() throws SQLException {
		// TODO Auto-generated method stub
		Set<Employee> unique=((EmployeeDBOperations) employeeOperations).uniqueEmployees();
		unique.forEach(System.out::println);
		
	}
	
	private void getSalaryCount() throws SQLException {
		// TODO Auto-generated method stub
		Map<Double,Integer> count = ((EmployeeDBOperations) employeeOperations).salaryCount();
		
		count.forEach((k,v)->System.out.println("Salary : " + k + " Count : " + v));
		
	}
	
	


}


/*public class EmployeeApplication {

    private EmployeeOperations employeeOperations = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        EmployeeApplication employeeApplication = new EmployeeApplication();
        
        System.out.println("************trng.Employee System**********");
        employeeApplication.initme();
        String sourceFile="G://Manoj//Software Engineering//IMCS//ClassTraining//PractiseTopics//bin//Book1.csv";
       employeeApplication.loadData(sourceFile);
        int choice = 0;
        int operations=0;
        boolean flag=true;
        while(flag==true){
        	try{
        		choice = EmployeeUtil.chooseOperation();
        		
        	}
        	catch(InputMismatchException exception){
        		System.out.println(exception + "  Please enter the valid choice");
        		continue;
        		
        	}
            switch (choice) {
                case 1:
                	
                	try{
                		employeeApplication.add();
                		operations=1;
                	}
                	catch(EmployeeCreationException e){
                		System.out.println(e + "  Problem in adding the employee,Please check the data given");
                	}
                	catch(InvalidSalaryException e){
                		System.out.println(e + "  Problem in adding the employee,Please check the data given");
                	}
                    break;
                case 2:
                	operations=1;
                    employeeApplication.display();
                    break;
                case 3:
                	operations=1;
                    employeeApplication.displayAll();
                    break;
                case 4:
                	
                	try{
                		employeeApplication.update();operations=1;
                	}
                	catch(EmployeeCreationException e){
                		System.out.println(e + "  problem updating the data");
                	}
                	catch(InvalidSalaryException e){
                		System.out.println(e + "  problem updating the data");
                	}
                    break;
                case 5:
                	operations=1;
                    employeeApplication.delete();
                    break;
                case 6:
                	operations=1;
                    employeeApplication.displayHRA();
                    break;
                case 7:
                	operations=1;
                    employeeApplication.displayGrossSalary();
                    break;
                case 8:
                	if(operations==1){
                		employeeApplication.saveData(sourceFile);
                	}
                	flag=false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } 

        scanner.close();
    }
    
    private void loadData(String sourceFile) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("Loading data from file");
    	@SuppressWarnings("unused")
		String destination="G://Manoj//Software Engineering//IMCS//ClassTraining//PractiseTopics//bin//Error.csv";
    	
    	try(BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
    			FileWriter fw =new FileWriter("destination",true);){
			
			String line;
			while((line=bufferedReader.readLine())!=null){
				String data[] = line.split(",");
				
				
					try{
						
						int id = Integer.parseInt(data[0]);
						String firstName = data[1];
						String lastName = data[2];
						double salary = Double.parseDouble(data[3]);
						int gender = Integer.parseInt(data[4]);
						
						
						Employee emp = new Employee(id,firstName,lastName,salary,null,gender);
						
							employeeOperations.createEmployee(emp);
						
						
					}
					catch(EmployeeCreationException e){
						System.out.println(e +"  Error in creating Employee, Please enter the valid data");
					}
					catch(InvalidSalaryException e){
						System.out.println(e + "  Error in creating Employee, Please enter the valid data");
					}
					catch(InputMismatchException e){						
						fw.append(line);	
					}
					
				
			}
			
		}
	}
	
	
	 private  void saveData(String sourceFile) throws IOException, SQLException {
			// TODO Auto-generated method stub
	    	List<Employee> employees = employeeOperations.findAll();
	    	try(FileWriter fw = new FileWriter(sourceFile,false);){
	    		for(Employee employee : employees){
	    			int gender = 0;
	    			if(employee.getGender() == Gender.valueOf("MALE")){
	    				gender=1;
	    			}
	    			else{
	    				gender=2;
	    			}
	    			String data = employee.getId() + "," +employee.getFirstName() + ","+employee.getLastName() + ","+employee.getSalary()+","+gender+"\n";
	    			fw.write(data);
	    		}
	    	}
	    	
			
		}



   
	

	private void displayGrossSalary() throws SQLException {
        System.out.println("Enter the employee id to calculte gross salary of employee");
        try{
        	int empNo = Integer.parseInt(scanner.next());
        	double grossSalary =employeeOperations.calculateGrossSal(empNo);
        	if(grossSalary == 0.0){
        		System.out.println("Employee id doesn't exist");
        	}
        	else{
        	System.out.println("Gross Salary of employee id " + empNo + " is : " + grossSalary);
        	}
        }
        catch(InputMismatchException e){
        	System.out.println( e + "  Please enter the valid id");
        }
        
        
    }

    private void displayHRA() throws SQLException {
        System.out.println("Enter the employee id to calculte hra of employee");
        try{
        	int number = Integer.parseInt(scanner.next());
        	double hra = employeeOperations.displayHRA(number);
        	if(hra==0.0){
        		System.out.println("Employee id doesn't exist");
        	}
        	else{
        		System.out.println("Hra of employee id " + number + " is : " + hra);
        	}
        }
        catch(InputMismatchException e){
        	System.out.println(e + "  Please enter the valid id");
        }
        
        
    }

    private void delete() {
        System.out.println("Enter the employee id to delete :");
        try{
        	int empId = scanner.nextInt();
        
        boolean flag = employeeOperations.deleteEmployee(empId);
        if (flag) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("No employee found with given number : " + empId);
        }
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter the valid id");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void update() throws EmployeeCreationException, InvalidSalaryException {
        System.out.println("Enter Employees data for update:");
        Employee employee = EmployeeUtil.readEmployee();
        try {
			employeeOperations.updateEmployee(employee);
		} catch (SQLException | InvalidEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void displayAll() throws SQLException {
        System.out.println("Employees in the system are :");
        List<Employee> employees = employeeOperations.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void display() {
        System.out.println("Enter the employee id to view employee info :");
        scanner=new Scanner(System.in);
        try{
        	int empId = scanner.nextInt();
        	Employee employee = employeeOperations.findEmployee(empId);
        	System.out.println(employee);
        }
        catch(InputMismatchException e){
        	System.out.println(e + " Please enter valid data");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void add() throws EmployeeCreationException, InvalidSalaryException {
        Employee employee = EmployeeUtil.readEmployee();
        employeeOperations.createEmployee(employee);
    }

    private void initme() {
        
        employeeOperations = new imcs.training.april2017.EmployeeOperations.Implementations.EmployeeArrayOperations(2);
    }


}*/