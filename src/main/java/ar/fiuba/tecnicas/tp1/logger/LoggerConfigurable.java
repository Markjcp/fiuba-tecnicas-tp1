package ar.fiuba.tecnicas.tp1.logger;

import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

public interface LoggerConfigurable {
	
	Level getLevel();
	
	void setLevel(Level level);
	
	boolean isEnabled();
	
	List<LoggerAppender> getLoggerAppenders();

}
