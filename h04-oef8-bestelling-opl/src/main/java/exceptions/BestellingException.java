package exceptions;

public class BestellingException extends Exception {

	public BestellingException() {
		super("Er loopt iets mis met de bestelling");
	}

	public BestellingException(String message) {
		super(message);
	}
}
