package ar.fiuba.tecnicas.tp1.logger;

import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

public class LoggerConfigurationBuilder {

	private LoggerConfiguration configuration;

	public LoggerConfigurationBuilder() {
		configuration = new LoggerConfiguration();
	}

	public LoggerConfigurationBuilder setLevel(Level level) {
		configuration.setLevel(level);
		return this;
	}

	public LoggerConfigurationBuilder setEnabled(boolean enabled) {
		configuration.setEnabled(enabled);
		return this;
	}

	public LoggerConfigurationBuilder setAppenders(
			List<LoggerAppender> appenders) {
		for (LoggerAppender loggerAppender : appenders) {
			configuration.addAppender(loggerAppender);
		}
		return this;
	}

	public LoggerConfiguration build() {
		return configuration;
	}

}
