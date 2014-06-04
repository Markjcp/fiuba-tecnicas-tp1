package ar.fiuba.tecnicas.tp1.factory;

import ar.fiuba.tecnicas.tp1.logger.Logger;

public class ComposedLoggerFactory implements LoggerFactory {

	private ConfigurationTemplateLoader template;

	public ComposedLoggerFactory() {
		template = new SimpleConfigurationTemplateLoader(
				new PropertiesConfigurationLoader(),
				new XmlConfigurationLoader());
	}

	public Logger createLogger() {
		return new Logger(template.loadValidConfigurable());
	}

}
