package ar.fiuba.tecnicas.tp1.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageFormatApplier {
	
	private MessageFormat messageFormat;
	// TODO: Deberia permitir levantarlo de properties
	private char delimiter = '-';
	
	public MessageFormatApplier(String format) {
		this.messageFormat = new MessageFormat(format);
	}
	
	public String applyFormat(String message) {
		return getDate() + getLevel() + getCurrentThread() + message + 
				getLineNumber() + getFileName() + getMethodName();
	}
	
	private String getDate() {
		if (!this.messageFormat.getDateFormat().isEmpty()) {
			DateFormat dateFormat = new SimpleDateFormat(this.messageFormat.getDateFormat());
			return dateFormat.format(new Date());
		}
		return "";
	}
	
	private String getLevel() {
		//TODO: Deberia devolver el nivel mas un separador
		return "";
	}
	
	private String getCurrentThread() {
		return Thread.currentThread().getName();
	}
	
	private String getLineNumber() {
		return String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber());
	}
	
	private String getFileName() {
		//TODO: Deberia devolver el nombre del archivo mas un separador
		return "";
	}
	
	private String getMethodName() {
		//TODO: Deberia devolver el nombre del metodo mas un separador
		return "";
	}
	
	private char getDelimiter() {
		return this.delimiter;
	}
}
