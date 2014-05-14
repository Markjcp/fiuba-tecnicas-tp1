package ar.fiuba.tecnicas.tp1.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageFormatApplier {
	
	//TODO: Debe ser creado en el Factory
	
	private MessageFormat messageFormat;
	
	public MessageFormatApplier(String format, String delimiter) {
		this.messageFormat = new MessageFormat(format, delimiter);
	}
	
	public String applyFormat(String message, Level level, String loggerName) {
		return getDate() + getDelimiter() + getLevel(level) + getCurrentThread() + 
				getMessage(message) + getLineNumber() + getFileName(loggerName) + getMethodName();
	}
	
	private String getDate() {
		if (!this.messageFormat.getDateFormat().isEmpty()) {
			DateFormat dateFormat = new SimpleDateFormat(this.messageFormat.getDateFormat());
			return dateFormat.format(new Date());
		}
		return "";
	}
	
	private String getLevel(Level level) {
		return this.messageFormat.levelIsVisible()?level.toString():"";
	}
	
	private String getCurrentThread() {
		return this.messageFormat.threadIsVisible() ? 
				Thread.currentThread().getName() : "";
	}
	
	private String getLineNumber() {
		return this.messageFormat.lineNumberIsVisible() ? 
				String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber()) : "";
	}
	
	private String getFileName(String fileName) {
		return this.messageFormat.fileNameIsVisible()?fileName:"";
	}
	
	private String getMethodName() {
		return this.messageFormat.methodNameIsVisible() ? 
				Thread.currentThread().getStackTrace()[1].getMethodName() : "";
	}
	
	private String getMessage(String message) {
		return this.messageFormat.messageIsVisible() ? message : "";
	}
	
	private String getDelimiter() {
		return this.messageFormat.getDelimiter();
	}
}
