package ar.fiuba.tecnicas.tp1.logger;

import java.util.Arrays;
import java.util.Vector;

import static ar.fiuba.tecnicas.tp1.factory.CreationConstants.*;

public class MessageFormat {
	
	private Vector<String> format;
	private String delimiter;
	
	public MessageFormat(String format, String delimiter) {
		this.delimiter = delimiter;
		this.format = new Vector<String>(Arrays.asList(format.split(delimiter)));
	}
	
	public int getModifiersSize(){
		return format.size();
	}
	
	public String getDelimiter() {
		return this.delimiter;
	}
	
	public String getDateFormat() {
		int resultFoundCode = dateIsVisible();
		if(resultFoundCode!=NOT_FOUND_FORMAT_CODE){
			String element = this.format.elementAt(resultFoundCode);
			return element.substring(element.indexOf('{') + 1, element.indexOf('}'));
		}
		return "";
	}
	
	public int dateIsVisible() {
		try {
			int i = 0;
			for (String current : format) {
				if (current.startsWith("%d") && current.charAt(2) == '{'
						&& current.charAt(current.length() - 1) == '}') {
					return i;
				}
				i++;
			}
			return NOT_FOUND_FORMAT_CODE;
		} catch (Exception e) {
			return NOT_FOUND_FORMAT_CODE;
		}
	}
	
	public int levelIsVisible() {
		return this.format.contains("%p") ? this.format.indexOf("%p") : NOT_FOUND_FORMAT_CODE;
	}
	
	public int threadIsVisible() {
		return this.format.contains("%t") ? this.format.indexOf("%t") : NOT_FOUND_FORMAT_CODE;
	}
	
	public int messageIsVisible() {
		return this.format.contains("%m") ? this.format.indexOf("%m") : NOT_FOUND_FORMAT_CODE;
	}
	
	public int delimiterIsVisible() {
		return this.format.contains("%n") ? this.format.indexOf("%n") : NOT_FOUND_FORMAT_CODE;
	}
	
	public int lineNumberIsVisible() {
		return this.format.contains("%L") ? this.format.indexOf("%L") : NOT_FOUND_FORMAT_CODE;
	}
	
	public int fileNameIsVisible() {
		return this.format.contains("%F") ? this.format.indexOf("%F") : NOT_FOUND_FORMAT_CODE;
	}
	
	public int methodNameIsVisible() {
		return this.format.contains("%M") ? this.format.indexOf("%M") : NOT_FOUND_FORMAT_CODE;
	}
	
}
