package imcs.training.april2017.EmployeeOperations.Pojo;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	public enum Gender{
		FEMALE,MALE;
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private String address;
	
	private Gender gender;
	
	

	public Employee() {
		super();
	}



	public Employee(int id) {
		super();
		this.id = id;
	}


	
	public Employee(int id, String firstName, String lastName, double salary,String address,int gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.address = address;
		if(gender == 1){
			this.gender = Gender.MALE;
		}else if(gender == 2){
			this.gender = Gender.FEMALE;
		}
	}

	
	

	public double calculateHRA(){
		//System.out.println(salary);
		double hra = (salary)*(20.00/100.00);
		//System.out.println(hra);
		return hra;	
		
	}
	
	public double calculateGrossSal(){
		
		double grossSal = this.salary + calculateHRA();
		return grossSal;
		
		
	}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	

	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public static Comparator<Employee> EmployeeNameComparator
    = new Comparator<Employee>() {

		public int compare(Employee employee1, Employee employee2) {

			String e1 = employee1.getFirstName().toUpperCase();
			String e2 = employee2.getFirstName().toUpperCase();

			//ascending order
			return e1.compareTo(e2);


		}

	};

	public int compareTo(Employee employee) {

		double compareSalary = ((Employee) employee).getSalary();

		//ascending order
		return (int) (this.salary - compareSalary);

		//descending order
		//return compareQuantity - this.quantity;

	}



	@Override
	public String toString() {
		return "trng.Employee [id=" + id + ", firstName=" + firstName + ", LastName=" + lastName + ", salary=" + salary
				+ ", address=" + address + ", gender=" + gender + "]";
	}




	

	
}
