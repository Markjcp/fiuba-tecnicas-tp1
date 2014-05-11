package ar.fiuba.tecnicas.tp1.logger;

public class SimpleLogMessage implements LogMessage{
	
	private String message;
	
	public SimpleLogMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getFormattedMessage() {
		return message;
	}

}
