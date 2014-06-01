package ar.fiuba.tecnicas.tp1.appenders;

import java.util.Map;

import ar.fiuba.tecnicas.tp1.exceptions.AppenderLoaderException;

/**
 * Extensión de la interfaz LoggerAppender para custom appenders 
 */
public interface CustomLoggerAppender extends LoggerAppender {

	/**
	 * Carga los parámetros particulares del custom appender
	 * @param parameters los parametros a cargar
	 * @throws AppenderLoaderException si existe un error en la carga
	 */
	public void loadAppenderParameters(Map<String,Object> parameters)
			throws AppenderLoaderException;

}
