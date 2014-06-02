package ar.fiuba.tecnicas.tp1.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="configuration")
public class ConfigurationXmlWrapper {

	private String level;
	
	private String separator;
	
	private String format;
	
	private boolean console;
	
	private List<FileAppenderXmlWrapper> fileAppenders;
	
	private List<CustomAppenderXmlWrapper> customAppenders;

	public String getLevel() {
		return level;
	}

	@XmlElement
	public void setLevel(String level) {
		this.level = level;
	}

	public String getSeparator() {
		return separator;
	}

	@XmlElement
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getFormat() {
		return format;
	}

	@XmlElement
	public void setFormat(String format) {
		this.format = format;
	}

	public boolean isConsole() {
		return console;
	}

	@XmlElement
	public void setConsole(boolean console) {
		this.console = console;
	}

	public List<FileAppenderXmlWrapper> getFileAppenders() {
		return fileAppenders;
	}

	@XmlElement(name="fileAppender")
	public void setFileAppenders(List<FileAppenderXmlWrapper> fileAppenders) {
		this.fileAppenders = fileAppenders;
	}

	public List<CustomAppenderXmlWrapper> getCustomAppenders() {
		return customAppenders;
	}

	@XmlElement(name="customAppender")
	public void setCustomAppenders(List<CustomAppenderXmlWrapper> customAppenders) {
		this.customAppenders = customAppenders;
	}	
}
