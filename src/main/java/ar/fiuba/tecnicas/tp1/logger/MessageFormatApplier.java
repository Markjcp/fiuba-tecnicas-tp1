package ar.fiuba.tecnicas.tp1.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageFormatApplier {
	
	private MessageFormat messageFormat;
	
	public MessageFormatApplier(String format) {
		this.messageFormat = new MessageFormat(format);
	}
	
	public String applyFormat(String message) {
		return getDate() + getDelimiter() + getLevel() + getCurrentThread() + 
				getMessage(message) + getLineNumber() + getFileName() + getMethodName();
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
		return this.messageFormat.threadIsVisible() ? 
				Thread.currentThread().getName() : "";
	}
	
	private String getLineNumber() {
		return this.messageFormat.lineNumberIsVisible() ? 
				String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber()) : "";
	}
	
	private String getFileName() {
		//TODO: Deberia devolver el nombre del archivo mas un separador
		return "";
	}
	
	private String getMethodName() {
		return this.messageFormat.methodNameIsVisible() ? 
				Thread.currentThread().getStackTrace()[1].getMethodName() : "";
	}
	
	private String getMessage(String message) {
		return this.messageFormat.messageIsVisible() ? message : "";
	}
	
	private char getDelimiter() {
		return this.messageFormat.getDelimiter();
	}
}
