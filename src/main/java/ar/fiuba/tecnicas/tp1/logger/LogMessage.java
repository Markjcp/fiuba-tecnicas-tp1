package ar.fiuba.tecnicas.tp1.logger;

import java.util.HashMap;

/**
 * Interfaz que define a un registro unitario de log
 *
 */
public interface LogMessage {
	
	String getMessage();
	
	String getFormattedMessage();
	
	Level getLevel();
	
	String getLoggerName();

	HashMap<String, String> getSlicedMessage();
}
