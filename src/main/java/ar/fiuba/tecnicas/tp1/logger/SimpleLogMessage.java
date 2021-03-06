package ar.fiuba.tecnicas.tp1.logger;

import java.util.HashMap;

/**
 * Implementación básica de un registro de log
 */
public class SimpleLogMessage implements LogMessage{
	
	private String message;
	
	private String formattedMessage;
	
	private Level level;
	
	private String loggerName;
	
	private HashMap<String,String> slicedMessage = new HashMap<String, String>();
	
	public SimpleLogMessage(HashMap<String,String> slicedMessage) {
		this.slicedMessage = slicedMessage;
	}
	
	public SimpleLogMessage(String message) {
		super();
		this.message = message;
	}
	
	public SimpleLogMessage(String message, String formattedMessage) {
		super();
		this.message = message;
		this.formattedMessage = formattedMessage;
	}

	public HashMap<String, String> getSlicedMessage() {
		return this.slicedMessage;
	}

	public String getMessage() {
		return message;
	}

	public String getFormattedMessage() {
		return formattedMessage;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}	

}
