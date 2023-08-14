package ssac.emp.kys;

public class EMSException extends Exception {
	public int code;
	
	public EMSException (String message, int code) {
		super(message);
		this.code = code;
	}

}
