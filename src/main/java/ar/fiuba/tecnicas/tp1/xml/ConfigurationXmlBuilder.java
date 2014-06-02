package ar.fiuba.tecnicas.tp1.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;

public class ConfigurationXmlBuilder {

	public static ConfigurationXmlWrapper build(String xmlName) {
		try {
			File file = new File(xmlName);
			JAXBContext jaxbContext = JAXBContext
					.newInstance(ConfigurationXmlWrapper.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ConfigurationXmlWrapper xmlWrapper = (ConfigurationXmlWrapper) jaxbUnmarshaller
					.unmarshal(file);
			return xmlWrapper;
		} catch (JAXBException e) {
			throw new LoadConfigurationException();
		}
	}

}
