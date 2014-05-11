package ar.fiuba.tecnicas.tp1.factory;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.ConsoleAppender;
import ar.fiuba.tecnicas.tp1.appenders.FileAppender;
import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;

public class SimpleLoggerFactory implements LoggerFactory {
	
	private static final String LOG_FILE="/home/marcos/log.txt";

	public Logger createLogger() {
		List<LoggerAppender> appenders = new ArrayList<LoggerAppender>();
		appenders.add(new ConsoleAppender());
		appenders.add(new FileAppender(LOG_FILE));
		Logger logger = new Logger(new LoggerConfigurationBuilder()
				.setEnabled(true).setLevel(Level.ERROR).setAppenders(appenders)
				.build());
		// @TODO construirlo ben
		return logger;
	}

}
