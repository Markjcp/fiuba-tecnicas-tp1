package ar.fiuba.tecnicas.tp1;

public class ConsoleAppender implements LoggerAppender{

	public void doLog(LogMessage message) {
		System.out.println(message.getMessage());		
	}

}
