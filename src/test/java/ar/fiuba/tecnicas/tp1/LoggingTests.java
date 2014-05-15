package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.factory.MockFactory;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;

/**
 * Tests relacionados al Logging con distintas combinaciones de niveles 
 */
public class LoggingTests {
	
	@Test
	public void testLoggingInfoVsInfo(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),false);
	}
	
	@Test
	public void testLoggingInfoVsWarn(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),false);
	}
	
	@Test
	public void testLoggingInfoVsError(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),false);
	}
	
	@Test
	public void testLoggingInfoVsFatal(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingInfoVsOff(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),false);
	}
	
	//
	@Test
	public void testLoggingWarnVsInfo(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),true);
	}
	
	@Test
	public void testLoggingWarnVsWarn(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),false);
	}
	
	@Test
	public void testLoggingWarnVsError(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),false);
	}
	
	@Test
	public void testLoggingWarnVsFatal(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingWarnVsOff(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),false);
	}
	
	//
	@Test
	public void testLoggingErrorVsInfo(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),true);
	}
	
	@Test
	public void testLoggingErrorVsWarn(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),true);
	}
	
	@Test
	public void testLoggingErrorVsError(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),false);
	}
	
	@Test
	public void testLoggingErrorVsFatal(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingErrorVsOff(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),false);
	}
	
	//
	@Test
	public void testLoggingOffVsInfo(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.OFF);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),true);
	}
	
	@Test
	public void testLoggingOffVsWarn(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.OFF);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),true);
	}
	
	@Test
	public void testLoggingOffVsError(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.OFF);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),true);
	}
	
	@Test
	public void testLoggingOffVsFatal(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.OFF);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),true);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingOffVsOff(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.OFF);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),true);
	}
	
	@Test
	public void testLoggingFatalVsInfo(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),true);
	}
	
	@Test
	public void testLoggingFatalVsWarn(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),true);
	}
	
	@Test
	public void testLoggingFatalVsError(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),true);
	}
	
	@Test
	public void testLoggingFatalVsFatal(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingFatalVsOff(){
		MockFactory mockFactory = new MockFactory();
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),false);
	}
}
