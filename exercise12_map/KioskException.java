package exercise12_map;

public class KioskException extends Exception {
	public int code;
	
	public KioskException(String message, int code) {
		super(message);
		this.code = code;
	}

	

}