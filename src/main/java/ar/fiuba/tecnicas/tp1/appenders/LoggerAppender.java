package ar.fiuba.tecnicas.tp1.appenders;

import ar.fiuba.tecnicas.tp1.logger.LogMessage;

/**
 * Interfaz que define aquelllos objetos que terminaran registrando el log 
 */
public interface LoggerAppender {
	
	/**
	 * Método de la interfaz LoggerAppender que definimitavamente realiza el log
	 */
	void doLog(LogMessage message);
}
