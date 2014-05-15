package ar.fiuba.tecnicas.tp1.exceptions;

/**
 * Excepcion no chequeada para cuando existe un problema de Append
 */
public class AppendException extends RuntimeException {

	private static final long serialVersionUID = 7965329803595392915L;

	public AppendException() {
		super();
	}

	public AppendException(String message) {
		super(message);
	}

}
