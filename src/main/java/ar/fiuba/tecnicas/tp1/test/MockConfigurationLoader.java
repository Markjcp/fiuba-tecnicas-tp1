package ar.fiuba.tecnicas.tp1.test;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.factory.ConfigurationLoader;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;

public class MockConfigurationLoader implements ConfigurationLoader {

	private Level level;

	public MockConfigurationLoader(Level level) {
		this.level = level;
	}

	public LoggerConfigurable loadConfigurable()
			throws LoadConfigurationException {
		List<LoggerAppender> appenders = new ArrayList<LoggerAppender>();
		appenders.add(new MockAppender());
		return new LoggerConfigurationBuilder().setEnabled(true)
				.setLevel(level).setAppenders(appenders).setFormat("%m")
				.setSeparator("-").build();
	}

}
