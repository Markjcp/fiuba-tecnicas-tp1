package ar.fiuba.tecnicas.tp1.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fileAppender")
public class FileAppenderXmlWrapper {
	
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	@XmlElement
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
