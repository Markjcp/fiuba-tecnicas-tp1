package ar.fiuba.tecnicas.tp1;

import static ar.fiuba.tecnicas.tp1.TestUtils.haveAllLoggersAppend;
import static ar.fiuba.tecnicas.tp1.util.AppendersEqualsHelper.areAppendersEqual;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.appenders.SimpleCustomAppender;
import ar.fiuba.tecnicas.tp1.factory.SimpleLoggerFactory;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;

/**
 * Tests referentes a los custom appenders 
 */
public class CustomAppenderTest {

	private Properties prop;

	private SimpleLoggerFactory factory;

	private LoggerAppender custom1;

	private LoggerAppender custom2;

	private List<LoggerAppender> customAppenders;

	@Before
	public void setup() {
		prop = new Properties();
		prop.setProperty("logger.level", "INFO");
		prop.setProperty("logger.appender.custom.custom1.class",
				"ar.fiuba.tecnicas.tp1.appenders.SimpleCustomAppender");
		prop.setProperty("logger.appender.custom.custom1.param1",
				"Custom Appender Info:");
		prop.setProperty("logger.appender.custom.custom1.param2", "Unimportant");
		prop.setProperty("logger.appender.custom.custom2.class",
				"ar.fiuba.tecnicas.tp1.appenders.SimpleCustomAppender");
		prop.setProperty("logger.appender.custom.custom2.param1", "Second:");
		prop.setProperty("logger.appender.custom.custom2.param2", "Unimportant");
		prop.setProperty("logger.message.format",
				"%m-%d{HH:mm:ss}-%t-%p-%L-%F-%M");
		prop.setProperty("logger.message.separator", "-");
		factory = new SimpleLoggerFactory();
		factory.setProperties(prop);
		custom1 = new SimpleCustomAppender();
		custom2 = new SimpleCustomAppender();
		customAppenders = new ArrayList<LoggerAppender>();
		customAppenders.add(custom1);
		customAppenders.add(custom2);
	}

	@Test
	public void testCustomAppenderCreation() {
		Logger logger = factory.createLogger();
		assertEquals(
				areAppendersEqual(logger.getConfigurationCopy()
						.getLoggerAppenders(), customAppenders), true);

	}

	@Test
	public void testCustomAppenderLog() {
		Logger logger = factory.createLogger();
		logger.log(Level.INFO, "Must log");
		assertEquals(haveAllLoggersAppend(logger.getConfigurationCopy()
				.getLoggerAppenders()), true);
	}

}
