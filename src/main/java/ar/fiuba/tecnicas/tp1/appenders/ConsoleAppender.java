package ar.fiuba.tecnicas.tp1.appenders;

import ar.fiuba.tecnicas.tp1.logger.LogMessage;

public class ConsoleAppender implements LoggerAppender{

	public void doLog(LogMessage message) {
		System.out.println(message.getFormattedMessage());		
	}

}
