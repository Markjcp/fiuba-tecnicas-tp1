package ar.fiuba.tecnicas.tp1.test;

import ar.fiuba.tecnicas.tp1.appenders.AbstractAppender;
import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.logger.LogMessage;

/**
 * Appender para realizar pruebas que loguea por consola  y registra la primera vez que se logueo 
 */
public class MockAppender extends AbstractAppender implements LoggerAppender {

	public void doLog(LogMessage message) {
		System.out.println("[MOCK APPENDER] Message: "
				+ message.getFormattedMessage());
		super.setLogged(true);

	}

	public boolean hasLogged() {
		return super.isLogged();
	}


}
