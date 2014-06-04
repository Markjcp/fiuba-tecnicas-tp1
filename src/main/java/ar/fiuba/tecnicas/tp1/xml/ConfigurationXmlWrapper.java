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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigurationXmlWrapper other = (ConfigurationXmlWrapper) obj;
		if (console != other.console)
			return false;
		if (customAppenders == null) {
			if (other.customAppenders != null)
				return false;
		} else if (customAppenders.size() != other.customAppenders.size())
			return false;
		if (fileAppenders == null) {
			if (other.fileAppenders != null)
				return false;
		} else if (fileAppenders.size() != other.fileAppenders.size())
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (separator == null) {
			if (other.separator != null)
				return false;
		} else if (!separator.equals(other.separator))
			return false;
		return true;
	}
	
	
}
