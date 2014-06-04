package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.factory.ConfigurationTemplateLoader;
import ar.fiuba.tecnicas.tp1.factory.SimpleConfigurationTemplateLoader;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfiguration;
import ar.fiuba.tecnicas.tp1.test.MockAppender;
import ar.fiuba.tecnicas.tp1.test.MockConfigurationLoader;

public class ConfigurationTemplateTests {
	
	private ConfigurationTemplateLoader template;
	
	private LoggerConfigurable config1;
	
	private LoggerConfigurable config2;
	
	@Before
	public void setup() {
		template = new SimpleConfigurationTemplateLoader(
				new MockConfigurationLoader(Level.INFO),
				new MockConfigurationLoader(Level.DEBUG));	
		
		config1 = new LoggerConfiguration();
		config1.setFormat("%m");
		config1.setLevel(Level.INFO);
		config1.setSeparator("-");
		config1.addAppender(new MockAppender());
		
		config2 = new LoggerConfiguration();
		config2.setFormat("%m");
		config2.setLevel(Level.DEBUG);
		config2.setSeparator("-");
		config2.addAppender(new MockAppender());
	}
	
	@Test
	public void testFirstConfigurationOption(){
		assertEquals(template.loadValidConfigurable(),config1);
	}
	
	@Test
	public void testFirstConfigurationOptionWrong(){
		assertEquals(template.loadValidConfigurable().equals(config2),false);
	}
	
	@Test
	public void testSecondtConfigurationOption(){
		template = new SimpleConfigurationTemplateLoader(
				new MockConfigurationLoader(Level.INFO),
				new MockConfigurationLoader(Level.DEBUG));
		template.swapOptions();
		assertEquals(template.loadValidConfigurable(),config2);
	}
	
	@Test
	public void testSecondConfigurationOptionWrong(){
		template = new SimpleConfigurationTemplateLoader(
				new MockConfigurationLoader(Level.INFO),
				new MockConfigurationLoader(Level.DEBUG));
		template.swapOptions();
		assertEquals(template.loadValidConfigurable().equals(config1),false);
	}

}
