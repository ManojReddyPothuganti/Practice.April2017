package imcs.trng.StudentJson.Pojo;

import java.util.List;



public class Student {
	
	private String name;
	protected List<Address> address;
	private List<Marks> marks;
	private double highestMarks;
	public Student(String name, List<Address> address, List<Marks> marks) {
		super();
		this.name = name;
		this.address = address;
		this.marks = marks;
	}
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public double getHighestMarks() {
		if(marks==null){
			return 0.0;
		}
		double max = 0;
		for(Marks score : marks){
			max = Math.max(max,score.getMarks());
		}
		return max;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", marks=" + marks + ", highestMarks=" + highestMarks
				+ "]";
	}
		

}
