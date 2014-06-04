package ar.fiuba.tecnicas.tp1.factory;

import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;

public abstract class ConfigurationTemplateLoader {
	
	public final LoggerConfigurable loadValidConfigurable(){
		try {
			if(getFirstOption() == null){
				throw new LoadConfigurationException();
			}
			return getFirstOption().loadConfigurable();
		} catch (LoadConfigurationException e) {
			return getSecondOption().loadConfigurable();
		}		
	}
	
	public final void swapOptions(){
		ConfigurationLoader aux = getSecondOption();
		setSecondOption(getFirstOption());
		setFirstOption(aux);
	}
	
	public abstract ConfigurationLoader getFirstOption();
	
	public abstract void setFirstOption(ConfigurationLoader first);
	
	public abstract ConfigurationLoader getSecondOption();
	
	public abstract void setSecondOption(ConfigurationLoader second);
}
