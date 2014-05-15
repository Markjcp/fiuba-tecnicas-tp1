package ar.fiuba.tecnicas.tp1.logger;

import static ar.fiuba.tecnicas.tp1.factory.CreationConstants.NOT_FOUND_FORMAT_CODE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageFormatApplier {
	
	//TODO: Debe ser creado en el Factory
	
	private MessageFormat messageFormat;
	
	public MessageFormatApplier(String format, String delimiter) {
		this.messageFormat = new MessageFormat(format, delimiter);
	}
	
	@Deprecated
	public String applyFormat(String message, Level level, String loggerName) {
		return getDate() + getDelimiter() + getLevel(level) + getCurrentThread() + 
				getMessage(message) + getLineNumber() + getFileName(loggerName) + getMethodName();
	}
	
	public String buildMessage(String message, Level level, String loggerName){
		int size = messageFormat.getModifiersSize();
		String[] modifiers = new String[size];
		int dateIndex = messageFormat.dateIsVisible();
		if( dateIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[dateIndex]= getDate();
		}
		int levelIndex = messageFormat.levelIsVisible();
		if( levelIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[levelIndex]=getLevel(level);
		}
		int threadIndex = messageFormat.threadIsVisible();
		if( threadIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[threadIndex]=getCurrentThread();
		}
		int messageIndex = messageFormat.messageIsVisible();
		if( messageIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[messageIndex]=getMessage(message);
		}
		int lineNumberIndex = messageFormat.lineNumberIsVisible();
		if( lineNumberIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[lineNumberIndex]= getLineNumber();
		}
		int fileNameIndex = messageFormat.fileNameIsVisible();
		if( fileNameIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[fileNameIndex]=getFileName(loggerName);
		}
		int methodNameIndex = messageFormat.methodNameIsVisible();
		if (methodNameIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[methodNameIndex]= getMethodName();
		}
		String result="";
		for (String modifier : modifiers) {
			if(!modifier.isEmpty()){
				result += modifier + " " + getDelimiter() + " ";				
			}
		}
		if(!result.equals("")){
			result=result.substring(0, result.length() - getDelimiter().length() -2);
		}
		return result;
		
	}
	
	private String getDate() {
		if (!this.messageFormat.getDateFormat().isEmpty()) {
			DateFormat dateFormat = new SimpleDateFormat(this.messageFormat.getDateFormat());
			return dateFormat.format(new Date());
		}
		return "";
	}
	
	private String getLevel(Level level) {
		return this.messageFormat.levelIsVisible()!=NOT_FOUND_FORMAT_CODE?level.toString():"";
	}
	
	private String getCurrentThread() {
		return this.messageFormat.threadIsVisible()!=NOT_FOUND_FORMAT_CODE ? 
				Thread.currentThread().getName() : "";
	}
	
	private String getLineNumber() {
		return this.messageFormat.lineNumberIsVisible()!=NOT_FOUND_FORMAT_CODE ? 
				String.valueOf(Thread.currentThread().getStackTrace()[4].getLineNumber()) : "";
	}
	
	private String getFileName(String fileName) {
		return this.messageFormat.fileNameIsVisible()!=NOT_FOUND_FORMAT_CODE?fileName:"";
	}
	
	private String getMethodName() {
		return this.messageFormat.methodNameIsVisible()!=NOT_FOUND_FORMAT_CODE ? 
				Thread.currentThread().getStackTrace()[4].getMethodName() : "";
	}
	
	private String getMessage(String message) {
		return this.messageFormat.messageIsVisible()!=NOT_FOUND_FORMAT_CODE ? message : "";
	}
	
	private String getDelimiter() {
		return this.messageFormat.getDelimiter();
	}
}
