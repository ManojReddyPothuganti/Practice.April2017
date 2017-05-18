package imcs.hibernate.Exceptions;

public class InvalidEmployeeException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public InvalidEmployeeException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidEmployeeException [msg=" + msg + "]";
	}
	
	

}
