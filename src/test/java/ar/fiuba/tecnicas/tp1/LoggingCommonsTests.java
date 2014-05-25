package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
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
	
	private boolean hasAppend(List<LoggerAppender> appenders){
		for (LoggerAppender loggerAppender : appenders) {
			if(loggerAppender.hasLogged()){
				return true;
			}
		}
		return false;
	}

}
