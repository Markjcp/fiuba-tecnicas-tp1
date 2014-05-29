package ar.fiuba.tecnicas.tp1.exceptions;

/**
 * Excepcion no chequeada para cuando no se encuentra un formateo deseado
 */
public class FormatNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4383332857055306399L;

	public FormatNotFoundException() {
		super();
	}

	public FormatNotFoundException(String message) {
		super(message);
	}

}
