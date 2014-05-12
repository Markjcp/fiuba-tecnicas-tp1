package ar.fiuba.tecnicas.tp1.logger;

import java.util.Arrays;
import java.util.Vector;

public class MessageFormat {
	
	private Vector<String> format;
	
	private String dateFormat;
	private boolean levelIsVisible;
	private boolean threadIsVisible;
	private boolean msgIsVisible;
	private boolean delimiterIsVisible;
	private boolean lineNumberIsVisible;
	private boolean fileNameIsVisible;
	private boolean methodNameIsVisible;
	
	public MessageFormat(String format) {
		//TODO: Deberia permitir mas separadores, lo levantaria de "properties"
		this.format = new Vector<String>(Arrays.asList(format.split("-")));
		setFormat();
	}
	
	private void setFormat() {
		setDateFormat().showLevel().showActualThread().showMessage().showDelimiter()
		.showLineNumber().showFileName().showMethodName();
	}
	
	private MessageFormat setDateFormat() {
		this.dateFormat = this.format.contains("%d") ? 
				this.format.elementAt(this.format.indexOf("%d")) : "";
		return this;
	}
	
	private MessageFormat showLevel() {
		this.levelIsVisible = this.format.contains("%p") ? true : false;
		return this;
	}
	
	private MessageFormat showActualThread() {
		this.threadIsVisible = this.format.contains("%t") ? true : false;		
		return this;
	}
	
	private MessageFormat showMessage() {
		this.msgIsVisible = this.format.contains("%m") ? true : false;		
		return this;
	}
	
	private MessageFormat showDelimiter() {
		this.delimiterIsVisible = this.format.contains("%n") ? true : false;		
		return this;
	}
	
	private MessageFormat showLineNumber() {
		this.lineNumberIsVisible = this.format.contains("%L") ? true : false;		
		return this;
	}
	
	private MessageFormat showFileName() {
		this.fileNameIsVisible = this.format.contains("%F") ? true : false;		
		return this;
	}
	
	private MessageFormat showMethodName() {
		this.methodNameIsVisible = this.format.contains("%M") ? true : false;		
		return this;
	}
	
}
