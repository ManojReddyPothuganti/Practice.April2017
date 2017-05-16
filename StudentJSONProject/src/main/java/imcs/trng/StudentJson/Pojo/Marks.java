package imcs.trng.StudentJson.Pojo;

public class Marks {

	private String subject;
    private double marks;
	public Marks(String subject, double marks) {
		super();
		this.subject = subject;
		this.marks = marks;
	}
	public Marks() {
		super();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Marks [subject=" + subject + ", marks=" + marks + "]";
	}
    
}
