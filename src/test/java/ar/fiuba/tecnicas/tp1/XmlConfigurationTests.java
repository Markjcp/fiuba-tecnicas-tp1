package ar.fiuba.tecnicas.tp1;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.factory.CreationConstants;
import ar.fiuba.tecnicas.tp1.xml.ConfigurationXmlBuilder;
import ar.fiuba.tecnicas.tp1.xml.ConfigurationXmlWrapper;

public class XmlConfigurationTests {

	@Test
	public void testXmlLoading() {
		ConfigurationXmlWrapper wrapper = ConfigurationXmlBuilder
				.build(CreationConstants.XML_CONFIGURATION_FILE);
		System.out.println(wrapper);
	}
}
