package ar.fiuba.tecnicas.tp1.factory;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;

/**
 * Implementación del LoggerFactory que toma un archivo properties y deja el logger configurad
 *
 */
public class SimpleLoggerFactory implements LoggerFactory {

	private Properties properties;

	public SimpleLoggerFactory() {
		try {
			this.properties = PropertyLoader
					.loadProperties(CreationConstants.DEFAULT_CONFIGURATION_FILE);
		} catch (IOException e) {
			throw new LoadConfigurationException();
		}
	}

	public Logger createLogger() {
		List<LoggerAppender> appenders = null;
		Level level = null;
		String format = "";
		String separator = "";
		appenders = PropertiesLoaderUtils.loadAppendersFromProperties(properties);
		level = Level.getLevelFromString((String) properties
				.getProperty(CreationConstants.LEVEL_KEY));
		format = properties.getProperty(CreationConstants.FORMAT_KEY);
		
		separator = properties.getProperty(CreationConstants.SEPARATOR_KEY);

		Logger logger = new Logger(new LoggerConfigurationBuilder()
				.setEnabled(true).setLevel(level).setAppenders(appenders)
				.setFormat(format).setSeparator(separator).build());
		return logger;
	}

	public void setProperties(Properties properties){
		this.properties = properties;
	}
}
