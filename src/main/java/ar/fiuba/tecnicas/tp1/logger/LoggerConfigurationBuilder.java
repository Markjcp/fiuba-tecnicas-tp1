package ar.fiuba.tecnicas.tp1.logger;

import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

/**
 * Clase que construye un LoggerConfiguration
 * @author marcos
 *
 */
public class LoggerConfigurationBuilder {

	private LoggerConfiguration configuration;

	public LoggerConfigurationBuilder() {
		configuration = new LoggerConfiguration();
	}

	public LoggerConfigurationBuilder setLevel(Level level) {
		configuration.setLevel(level);
		return this;
	}
	
	public LoggerConfigurationBuilder(LoggerConfiguration configuration) {
		super();
		this.configuration = configuration;
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
	
	public LoggerConfigurationBuilder setFormat(String format){
		configuration.setFormat(format);
		return this;
	}
	
	public LoggerConfigurationBuilder setSeparator(String separator){
		configuration.setSeparator(separator);
		return this;
	}

	/**
	 * Método contructor
	 * @return el objeto de configuración construido
	 */
	public LoggerConfiguration build() {
		return configuration;
	}

}
