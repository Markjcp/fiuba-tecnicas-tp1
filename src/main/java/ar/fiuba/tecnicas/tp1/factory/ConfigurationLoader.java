package ar.fiuba.tecnicas.tp1.factory;

import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;

public interface ConfigurationLoader {
	
	LoggerConfigurable loadConfigurable() throws LoadConfigurationException;

}
