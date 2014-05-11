package ar.fiuba.tecnicas.tp1;

import java.util.List;

public interface LoggerConfigurable {
	
	Level getLevel();
	
	void setLevel(Level level);
	
	boolean isEnabled();
	
	List<LoggerAppender> getLoggerAppenders();

}
