package ar.fiuba.tecnicas.tp1.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customAppender")
public class CustomAppenderXmlWrapper {

	private String className;

	private List<CustomAppenderXmlWrapperParam> params;

	public String getClassName() {
		return className;
	}

	@XmlElement
	public void setClassName(String className) {
		this.className = className;
	}

	public List<CustomAppenderXmlWrapperParam> getParams() {
		return params;
	}

	@XmlElement(name="param")
	public void setParams(List<CustomAppenderXmlWrapperParam> params) {
		this.params = params;
	}
}
