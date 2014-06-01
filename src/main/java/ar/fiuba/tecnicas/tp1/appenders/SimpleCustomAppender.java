package ar.fiuba.tecnicas.tp1.appenders;

import java.util.Map;

import ar.fiuba.tecnicas.tp1.exceptions.AppenderLoaderException;
import ar.fiuba.tecnicas.tp1.logger.LogMessage;

/**
 * Implementación básica de un CustomLoggerAppender
 */
public class SimpleCustomAppender extends AbstractAppender implements
		CustomLoggerAppender {
	
	private static final String PARAM1_KEY="param1";

	private String description;

	public void doLog(LogMessage message) {
		System.out.println(description + " Message: "
				+ message.getFormattedMessage());
		super.setLogged(true);
	}

	public boolean hasLogged() {
		return super.isLogged();
	}

	public void loadAppenderParameters(Map<String,Object> parameters)
			throws AppenderLoaderException {
		try {
			this.description = (String)parameters.get(PARAM1_KEY);
		} catch (Exception e) {
			throw new AppenderLoaderException();
		}

	}

}
