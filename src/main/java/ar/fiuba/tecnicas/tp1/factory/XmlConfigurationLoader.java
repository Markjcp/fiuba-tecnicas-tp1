package ar.fiuba.tecnicas.tp1.factory;

import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;
import ar.fiuba.tecnicas.tp1.xml.ConfigurationXmlBuilder;
import ar.fiuba.tecnicas.tp1.xml.ConfigurationXmlWrapper;
import ar.fiuba.tecnicas.tp1.xml.LoggerConfigurationAdapter;

public class XmlConfigurationLoader implements ConfigurationLoader {

	public LoggerConfigurable loadConfigurable()
			throws LoadConfigurationException {
		ConfigurationXmlWrapper wrapper = ConfigurationXmlBuilder
				.build(CreationConstants.XML_CONFIGURATION_FILE);
		return LoggerConfigurationAdapter.adaptFromXmlWrapper(wrapper);
	}

}
