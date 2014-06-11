package ar.fiuba.tecnicas.tp1.logger;

import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

/**
 * Interfaz que define el comportamiento básico de una configuración de Logger
 *
 */
public interface LoggerConfigurable{
	
	Level getLevel();
	
	void setLevel(Level level);
	
	boolean isEnabled();
	
	List<LoggerAppender> getLoggerAppenders();
	
	MessageFormat getFormat();
	
	void setFormat(String format);
	
	String getSeparator();
	
	void setSeparator(String separator);
	
	void addAppender(LoggerAppender appender);
	
	LoggerConfigurable copy();
	
	boolean isJsonFormatAvailable();
	
	void enableJsonFormat();
	
	

}
