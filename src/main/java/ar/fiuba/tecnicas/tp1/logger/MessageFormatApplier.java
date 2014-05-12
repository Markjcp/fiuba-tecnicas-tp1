package ar.fiuba.tecnicas.tp1.logger;

public class MessageFormatApplier {
	
	private MessageFormat messageFormat;
	
	public MessageFormatApplier(String format) {
		this.messageFormat = new MessageFormat(format);
	}
	
	public String applyFormat(String message) {
		return getDate() + getLevel() + getActualThread() + message + 
				getLineNumber() + getFileName() + getMethodName();
	}
	
	private String getDate() {
		//TODO: Deberia devolver la fecha mas un separador
		return "";
	}
	
	private String getLevel() {
		//TODO: Deberia devolver el nivel mas un separador
		return "";
	}
	
	private String getActualThread() {
		//TODO: Deberia devolver el thread mas un separador
		return "";
	}
	
	private String getLineNumber() {
		//TODO: Deberia devolver el numero de linea mas un separador
		return "";
	}
	
	private String getFileName() {
		//TODO: Deberia devolver el nombre del archivo mas un separador
		return "";
	}
	
	private String getMethodName() {
		//TODO: Deberia devolver el nombre del metodo mas un separador
		return "";
	}
}
