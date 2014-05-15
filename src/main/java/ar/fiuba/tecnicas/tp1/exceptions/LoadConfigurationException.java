package ar.fiuba.tecnicas.tp1.exceptions;

/**
 * Excepcion no chequeada para lanzar cuando existe un error de configuracion
 *
 */
public class LoadConfigurationException extends RuntimeException {

	private static final long serialVersionUID = -312239753744708030L;

	public LoadConfigurationException() {
		super();
	}

	public LoadConfigurationException(String message) {
		super(message);
	}

}
