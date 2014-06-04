package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;
import static ar.fiuba.tecnicas.tp1.TestUtils.hasAppend;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.test.MockFactory;

public class LoggingCommonsTests {
	
	private MockFactory mockFactory;
	
	@Before
	public void setup(){
		mockFactory = new MockFactory();
	}
	
	@Test
	public void mustLoggingTest(){
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(hasAppend(logger.getConfigurationCopy().getLoggerAppenders()),false);
		logger.log(Level.INFO, "mustLoggingTest");
		assertEquals(hasAppend(logger.getConfigurationCopy().getLoggerAppenders()),true);
	}
	
	@Test
	public void mustNotLoggingTest(){
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(hasAppend(logger.getConfigurationCopy().getLoggerAppenders()),false);
		logger.log(Level.INFO, "mustLoggingTest");
		assertEquals(hasAppend(logger.getConfigurationCopy().getLoggerAppenders()),false);
	}
	
	@Test
	public void testMultipleLoggers(){
		
		mockFactory.setLevel(Level.INFO);
		Logger logger1 = mockFactory.createLogger();
		logger1.log(Level.WARN, "log from logger1");
		
		mockFactory.setLevel(Level.WARN);
		Logger logger2 = mockFactory.createLogger();
		logger2.log(Level.INFO, "log from logger2");
		
		assertEquals(hasAppend(logger1.getConfigurationCopy().getLoggerAppenders()),true);
		assertEquals(hasAppend(logger2.getConfigurationCopy().getLoggerAppenders()),false);
	}	
	

}
