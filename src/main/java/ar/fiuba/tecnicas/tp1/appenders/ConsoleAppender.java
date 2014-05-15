package ar.fiuba.tecnicas.tp1.appenders;

import ar.fiuba.tecnicas.tp1.logger.LogMessage;

/**
 * Appender para loguear por consola
 *
 */
public class ConsoleAppender implements LoggerAppender{

	/**
	 * Método de la interfaz LoggerAppender que definimitavamente realiza el log
	 */
	public void doLog(LogMessage message) {
		System.out.println(message.getFormattedMessage());		
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ConsoleAppender;
	}

}
