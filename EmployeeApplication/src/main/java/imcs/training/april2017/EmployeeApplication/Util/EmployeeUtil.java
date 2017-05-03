package imcs.training.april2017.EmployeeApplication.Util;

import java.util.InputMismatchException;
import java.util.Scanner;

import imcs.training.april2017.EmployeeOperations.Exceptions.EmployeeCreationException;
import imcs.training.april2017.EmployeeOperations.Pojo.Employee;

public class EmployeeUtil {

    private static Scanner scanner ;//= new Scanner(System.in);

    public static int chooseOperation() throws InputMismatchException {
    	scanner  = new Scanner(System.in);
        System.out.println();
        System.out.println("   ||| MENU |||   ");
        System.out.println("1. Create trng.Employee");
        System.out.println("2. Read(View) trng.Employee");
        System.out.println("3. View all Employees");
        System.out.println("4. Update trng.Employee");
        System.out.println("5. Delete trng.Employee");
        System.out.println("6. Calculate HRA");
        System.out.println("7. Calculate Gross Salary");
        System.out.println("8. Sort Employees");
        System.out.println("9. View unique Employees");
        System.out.println("10. View salary count");
        System.out.println("11. Exit");


        System.out.print("Select a choice :");
        
        int id=scanner.nextInt();
        	return id;
    }

    public static Employee readEmployee() throws EmployeeCreationException {
    	scanner = new Scanner(System.in);
    	boolean flag=true;
    	while(flag==true){
    		
    	try{
        System.out.print("Enter trng.Employee id:");
        int id = scanner.nextInt();

        System.out.print("Enter trng.Employee firstname:");
        String firstName = scanner.next();

        System.out.print("Enter trng.Employee lastname:");
        String lastName = scanner.next();

        System.out.print("Enter trng.Employee Salary: between (1 and 100000)");
        double salary = scanner.nextDouble();

        System.out.println("Select the gender");
        System.out.println("	1.Male");
        System.out.println("	2.Female");

        int gender = scanner.nextInt();
        if(gender >2 || gender <1){
        	throw new EmployeeCreationException("Please enter the valid data");
        }
        
        return new Employee(id, firstName, lastName, salary,null, gender);
        }
    	catch(InputMismatchException e){
    		throw new EmployeeCreationException("Please enter valid data ");
    	}
    	}
		return null;	
        
    }

	public static int sortDataUtil(){
		// TODO Auto-generated method stub
		scanner =new Scanner(System.in);
		System.out.println("Please enter the sorting criteria");
		System.out.println("1.Name \n 2.Salary");
		try{
			int criteria=scanner.nextInt();
			return criteria;
		}
		catch(InputMismatchException e){
			System.out.println(e + "  Please enter the valid input 1 or 2");
		}
		
		return 0;
	}

	
}
