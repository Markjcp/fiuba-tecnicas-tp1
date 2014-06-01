package ar.fiuba.tecnicas.tp1.exceptions;

/**
 * Checked Exception si existió un error en la carga de un appender
 */
public class AppenderLoaderException extends Exception {

	private static final long serialVersionUID = -8208220169085030984L;

	public AppenderLoaderException() {
		super();
	}

	public AppenderLoaderException(String name) {
		super(name);
	}

}
