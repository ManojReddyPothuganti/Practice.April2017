package imcs.hibernate.Exceptions;

public class InvalidSalaryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2125314252286300094L;
	private String errormsg;

	public InvalidSalaryException(String errormsg) {
		super();
		this.errormsg = errormsg;
	}

	@Override
	public String toString() {
		return "InvalidSalaryException [errormsg=" + errormsg + "]";
	}
	

}
