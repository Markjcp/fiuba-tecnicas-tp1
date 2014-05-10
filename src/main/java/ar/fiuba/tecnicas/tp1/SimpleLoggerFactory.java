package ar.fiuba.tecnicas.tp1;

import java.util.ArrayList;
import java.util.List;

public class SimpleLoggerFactory implements LoggerFactory {

	public Logger createLogger() {
		List<LoggerAppender> appenders = new ArrayList<LoggerAppender>();
		appenders.add(new ConsoleAppender());
		Logger logger = new Logger(new LoggerConfigurationBuilder()
				.setEnabled(true).setLevel(Level.ERROR).setAppenders(appenders)
				.build());
		// @TODO construirlo ben
		return logger;
	}

}
