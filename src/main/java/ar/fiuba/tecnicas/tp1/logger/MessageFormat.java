package ar.fiuba.tecnicas.tp1.logger;

import java.util.Arrays;
import java.util.Vector;

public class MessageFormat {
	
	private Vector<String> format;
	
	public MessageFormat(String format) {
		//TODO: Deberia permitir mas separadores, lo levantaria de "properties"
		this.format = new Vector<String>(Arrays.asList(format.split("-")));
	}
	
	public String getDateFormat() {
		return this.format.contains("%d") ? 
				this.format.elementAt(this.format.indexOf("%d")) : "";
	}
	
	public boolean levelIsVisible() {
		return this.format.contains("%p") ? true : false;
	}
	
	public boolean threadIsVisible() {
		return this.format.contains("%t") ? true : false;
	}
	
	public boolean msgIsVisible() {
		return this.format.contains("%m") ? true : false;
	}
	
	public boolean delimiterIsVisible() {
		return this.format.contains("%n") ? true : false;
	}
	
	public boolean lineNumberIsVisible() {
		return this.format.contains("%L") ? true : false;
	}
	
	public boolean fileNameIsVisible() {
		return this.format.contains("%F") ? true : false;
	}
	
	public boolean methodNameIsVisible() {
		return this.format.contains("%M") ? true : false;
	}
	
}
