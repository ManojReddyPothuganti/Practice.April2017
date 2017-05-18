package imcs.hibernate.Exceptions;

public class EmployeeCreationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2756936248782959825L;
	private String errormsg;

	public EmployeeCreationException(String errormsg) {
		super();
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		return "EmployeeCreationException [errormsg=" + errormsg + "]";
	}
	
	

}
