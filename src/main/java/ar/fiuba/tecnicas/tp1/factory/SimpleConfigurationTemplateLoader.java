package ar.fiuba.tecnicas.tp1.factory;

public class SimpleConfigurationTemplateLoader extends
		ConfigurationTemplateLoader {

	private ConfigurationLoader firstOption;

	private ConfigurationLoader secondOption;

	public SimpleConfigurationTemplateLoader(ConfigurationLoader firstOption,
			ConfigurationLoader secondOption) {
		super();
		this.firstOption = firstOption;
		this.secondOption = secondOption;
	}

	@Override
	public ConfigurationLoader getFirstOption() {
		return this.firstOption;
	}

	@Override
	public void setFirstOption(ConfigurationLoader first) {
		this.firstOption = first;

	}

	@Override
	public ConfigurationLoader getSecondOption() {
		return this.secondOption;
	}

	@Override
	public void setSecondOption(ConfigurationLoader second) {
		this.secondOption = second;
	}

}
