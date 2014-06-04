package ar.fiuba.tecnicas.tp1.factory;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;

public class PropertiesConfigurationLoader implements ConfigurationLoader {

	public LoggerConfigurable loadConfigurable()
			throws LoadConfigurationException {

		Properties properties = null;
		try {
			properties = PropertyLoader
					.loadProperties(CreationConstants.DEFAULT_CONFIGURATION_FILE);
		} catch (IOException e) {
			throw new LoadConfigurationException();
		}
		List<LoggerAppender> appenders = null;
		Level level = null;
		String format = "";
		String separator = "";
		appenders = PropertiesLoaderUtils
				.loadAppendersFromProperties(properties);
		level = Level.getLevelFromString((String) properties
				.getProperty(CreationConstants.LEVEL_KEY));
		format = properties.getProperty(CreationConstants.FORMAT_KEY);
		separator = properties.getProperty(CreationConstants.SEPARATOR_KEY);
		return new LoggerConfigurationBuilder().setEnabled(true)
				.setLevel(level).setAppenders(appenders).setFormat(format)
				.setSeparator(separator).build();
	}

}
