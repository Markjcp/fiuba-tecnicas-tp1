package ar.fiuba.tecnicas.tp1;

import java.util.List;

public class Logger {

	private LoggerConfigurable configuration;

	public Logger(LoggerConfigurable configuration) {
		super();
		this.configuration = configuration;
	}

	public static Logger getLogger(Class<?> aClass) {
		return getLogger(aClass.getName());
	}

	public static Logger getLogger(String name) {
		return LoggerManager.getInstance().getLogger(name);
	}

	public void log(Level level, String message) {
		log(level, new SimpleLogMessage(message));
	}

	private boolean skipLogging(Level level) {
		return !configuration.isEnabled()
				|| level.compareTo(configuration.getLevel()) < 0;
	}

	public void log(Level level, LogMessage message) {
		if (skipLogging(level)) {
			return;
		}
		List<LoggerAppender> appenders = configuration.getLoggerAppenders();
		for (LoggerAppender loggerAppender : appenders) {
			loggerAppender.doLog(message);
		}
	}

	public void info(String message) {
		log(Level.INFO, message);
	}

	public void info(LogMessage message) {
		log(Level.INFO, message);
	}

	public void warn(String message) {
		log(Level.WARN, message);
	}

	public void warn(LogMessage message) {
		log(Level.WARN, message);
	}

	public void error(String message) {
		log(Level.ERROR, message);
	}

	public void error(LogMessage message) {
		log(Level.ERROR, message);
	}

	public void fatal(String message) {
		log(Level.FATAL, message);
	}

	public void fatal(LogMessage message) {
		log(Level.FATAL, message);
	}

}
