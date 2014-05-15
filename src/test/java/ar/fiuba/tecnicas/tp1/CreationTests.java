package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.appenders.ConsoleAppender;
import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.factory.MockFactory;
import ar.fiuba.tecnicas.tp1.factory.SimpleLoggerFactory;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfiguration;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;
import ar.fiuba.tecnicas.tp1.logger.LoggerManager;

/**
 * Tests referentes a la creación de objetos utilizados en el desarrollo
 *
 */
public class CreationTests {
	
	@Test
	public void testSingletonManager(){
		LoggerManager manager = LoggerManager.getInstance();
		LoggerManager manager2 = LoggerManager.getInstance();
		assertEquals(manager.equals(manager2), true);
	}

	@Test
	public void testManagerCreation() {
		LoggerManager manager = LoggerManager.getInstance();
		manager.setFactory(new MockFactory());
		Logger.getLogger(CreationTests.class);
		assertEquals(manager.isLoggerRegistered(CreationTests.class.getName()),
				true);
	}

	@Test
	public void testFactoryCreation() {
		SimpleLoggerFactory factory1 = new SimpleLoggerFactory();
		Logger logger1 = factory1.createLogger();
		Properties prop = new Properties();
		prop.setProperty("logger.level", "INFO");
		prop.setProperty("logger.appender.file.original",
				"/home/marcos/log0.txt");
		prop.setProperty("logger.appender.file.bench ", "/home/marcos/log1.txt");
		prop.setProperty("logger.appender.file.third ", "/home/marcos/log2.txt");
		prop.setProperty("logger.appender.console", "true");
		prop.setProperty("logger.message.format",
				"%m-%d{HH:mm:ss}-%t-%p-%L-%F-%M");
		prop.setProperty("logger.message.separator", "-");
		SimpleLoggerFactory factory2 = new SimpleLoggerFactory();
		factory2.setProperties(prop);
		Logger logger2 = factory2.createLogger();
		assertEquals(logger1.equals(logger2), true);
	}

	@Test
	public void testConfigurationBuilder() {
		LoggerConfigurationBuilder builder = new LoggerConfigurationBuilder();
		List<LoggerAppender> appenders = new ArrayList<LoggerAppender>();
		appenders.add(new ConsoleAppender());
		LoggerConfiguration conf1 = builder.setAppenders(appenders)
				.setEnabled(true).setFormat("%m").setLevel(Level.INFO)
				.setSeparator("-").build();
		LoggerConfiguration conf2 = new LoggerConfiguration();
		conf2.setEnabled(true);
		conf2.setFormat("%m");
		conf2.setLevel(Level.INFO);
		conf2.setSeparator("-");
		conf2.addAppender(new ConsoleAppender());
		assertEquals(conf1.equals(conf2), true);
	}

}
