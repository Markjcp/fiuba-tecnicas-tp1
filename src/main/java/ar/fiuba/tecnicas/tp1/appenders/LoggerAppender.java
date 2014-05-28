package ar.fiuba.tecnicas.tp1.appenders;

import ar.fiuba.tecnicas.tp1.logger.LogMessage;

/**
 * Interfaz que define aquelllos objetos que terminaran registrando el log 
 */
public interface LoggerAppender {
	
	/**
	 * Método de la interfaz LoggerAppender que realiza el log
	 */
	void doLog(LogMessage message);
	
	/**
	 * Define si se ha logueado alguna vez para esa instancia
	 * @return verdadero si se logueo, falso en caso contrario
	 */
	boolean hasLogged();
}
