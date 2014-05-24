package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.test.MockFactory;

/**
 * Tests relacionados al Logging con distintas combinaciones de niveles 
 */
public class LoggingLevelTests {
	
	private MockFactory mockFactory;
	
	@Before
	public void setup(){
		mockFactory = new MockFactory();
	}

	
	@Test
	public void testLoggingInfoVsInfo(){
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),false);
	}
	
	@Test
	public void testLoggingInfoVsWarn(){
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),false);
	}
	
	@Test
	public void testLoggingInfoVsError(){
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),false);
	}
	
	@Test
	public void testLoggingInfoVsFatal(){
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingInfoVsOff(){
		mockFactory.setLevel(Level.INFO);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),false);
	}
	
	//
	@Test
	public void testLoggingWarnVsInfo(){
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),true);
	}
	
	@Test
	public void testLoggingWarnVsWarn(){
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),false);
	}
	
	@Test
	public void testLoggingWarnVsError(){
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),false);
	}
	
	@Test
	public void testLoggingWarnVsFatal(){
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingWarnVsOff(){
		mockFactory.setLevel(Level.WARN);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),false);
	}
	
	//
	@Test
	public void testLoggingErrorVsInfo(){
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.INFO),true);
	}
	
	@Test
	public void testLoggingErrorVsWarn(){
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.WARN),true);
	}
	
	@Test
	public void testLoggingErrorVsError(){
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),false);
	}
	
	@Test
	public void testLoggingErrorVsFatal(){
		mockFactory.setLevel(Level.ERROR);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingErrorVsOff(){
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
		mockFactory.setLevel(Level.OFF);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),true);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingOffVsOff(){
		mockFactory.setLevel(Level.OFF);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),true);
	}
	
	@Test
	public void testLoggingFatalVsInfo(){
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
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.ERROR),true);
	}
	
	@Test
	public void testLoggingFatalVsFatal(){
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.FATAL),false);
	}
	
	//Si se loguea algo con nivel OFF se mostraría
	@Test
	public void testLoggingFatalVsOff(){
		mockFactory.setLevel(Level.FATAL);
		Logger logger = mockFactory.createLogger();
		assertEquals(logger.skipLogging(Level.OFF),false);
	}
}
