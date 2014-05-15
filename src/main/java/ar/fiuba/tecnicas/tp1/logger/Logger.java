package ar.fiuba.tecnicas.tp1.logger;

import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

public class Logger {

	private LoggerConfigurable configuration;
	
	private MessageFormatApplier messageFormatApplier;

	public Logger(LoggerConfigurable configuration) {
		super();
		this.configuration = configuration;
		this.messageFormatApplier= new MessageFormatApplier(configuration.getFormat(), configuration.getSeparator());
	}

	public static Logger getLogger(Class<?> aClass) {
		return getLogger(aClass.getName());
	}

	public static Logger getLogger(String name) {
		return LoggerManager.getInstance().getLogger(name);
	}

	public void log(Level level, String message) {
		log(level,
				new SimpleLogMessage(message, messageFormatApplier.buildMessage(
						message, level, LoggerManager.getInstance()
								.getLoggerName(this))));
	}

	public boolean skipLogging(Level level) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((configuration == null) ? 0 : configuration.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logger other = (Logger) obj;
		if (configuration == null) {
			if (other.configuration != null)
				return false;
		} else if (!configuration.equals(other.configuration))
			return false;
		return true;
	}
	
	

}
