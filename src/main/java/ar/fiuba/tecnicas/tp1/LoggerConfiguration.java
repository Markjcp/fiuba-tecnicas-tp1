package ar.fiuba.tecnicas.tp1;

import java.util.ArrayList;
import java.util.List;

public class LoggerConfiguration implements LoggerConfigurable {

	private Level level;

	private boolean enabled = true;

	private List<LoggerAppender> appenders;

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addAppender(LoggerAppender appender) {
		if (appenders == null) {
			appenders = new ArrayList<LoggerAppender>();
		}
		appenders.add(appender);
	}

	public List<LoggerAppender> getLoggerAppenders() {
		return appenders;
	}

}
