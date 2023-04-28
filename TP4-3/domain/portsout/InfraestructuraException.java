package portsout;

public class InfraestructuraException extends Exception {

	public InfraestructuraException(Exception ex, String msg) {
		super(msg, ex);
	}

}
