package ar.fiuba.tecnicas.tp1.test;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.factory.LoggerFactory;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;

/**
 *  Factory utilizado para test con datos fijos
 */
public class MockFactory implements LoggerFactory {

	private Level level;

	public MockFactory() {
		level = Level.ERROR;
	}

	public Logger createLogger() {
		List<LoggerAppender> appenders = new ArrayList<LoggerAppender>();
		appenders.add(new MockAppender());
		Logger logger = new Logger(new LoggerConfigurationBuilder()
				.setEnabled(true).setLevel(level).setAppenders(appenders)
				.setFormat("%m").setSeparator("-").build());
		return logger;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
