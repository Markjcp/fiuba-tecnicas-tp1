package ar.fiuba.tecnicas.tp1.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import ar.fiuba.tecnicas.tp1.appenders.ConsoleAppender;
import ar.fiuba.tecnicas.tp1.appenders.FileAppender;
import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;

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
		appenders = loadAppendersFromProperties(properties);
		level = Level.getLevelFromString((String) properties
				.getProperty(CreationConstants.LEVEL_KEY));
		format = properties.getProperty(CreationConstants.FORMAT_KEY);
		separator = properties.getProperty(CreationConstants.SEPARATOR_KEY);

		Logger logger = new Logger(new LoggerConfigurationBuilder()
				.setEnabled(true).setLevel(level).setAppenders(appenders)
				.setFormat(format).setSeparator(separator).build());
		return logger;
	}

	private boolean isValidFileAppenderKey(String key) {
		return key.startsWith(CreationConstants.FILE_APPENDER_KEY)
				&& key.length() > CreationConstants.FILE_APPENDER_KEY.length();

	}

	private boolean isValidConsoleAppenderKey(String key) {
		return key.equals(CreationConstants.CONSOLE_APPENDER_KEY);

	}

	private String cutAppenderName(String prefix, String entireKey) {
		return entireKey.substring(prefix.length(), entireKey.length());
	}

	private List<LoggerAppender> loadAppendersFromProperties(
			Properties properties) {
		Set<Object> keys = properties.keySet();
		List<LoggerAppender> result = new ArrayList<LoggerAppender>();
		boolean consoleFound = false;
		for (Object key : keys) {
			String keyStr = (String) key;
			if (isValidFileAppenderKey(keyStr)) {
				String appenderValue = properties.getProperty(keyStr);
				FileAppender fileAppender = new FileAppender(appenderValue);
				fileAppender.setAppenderName(cutAppenderName(
						CreationConstants.FILE_APPENDER_KEY, keyStr));
				result.add(fileAppender);
			} else if (!consoleFound && isValidConsoleAppenderKey(keyStr)) {
				String appenderValue = properties.getProperty(keyStr);
				if (Boolean.valueOf(appenderValue).booleanValue()) {
					consoleFound = true;
					result.add(new ConsoleAppender());
				}
			}
		}
		return result;
	}
	
	public void setProperties(Properties properties){
		this.properties = properties;
	}

}
