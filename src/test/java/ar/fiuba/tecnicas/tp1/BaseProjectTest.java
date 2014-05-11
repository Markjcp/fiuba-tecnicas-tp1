package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;

public class BaseProjectTest {
	
	private static Logger logger = Logger.getLogger(BaseProjectTest.class);
	
	@Test
	public void testBaseConfiguration(){
		assertEquals(true,true);
	}
	
	@Test
	public void testBaseLoggingInfo(){
		logger.log(Level.INFO, "Logueamos 1");
	}

	@Test
	public void testBaseLoggingWarn(){
		logger.log(Level.WARN, "Logueamos 2");
	}
	
	@Test
	public void testBaseLoggingError(){
		logger.log(Level.ERROR, "Logueamos 3");
	}
	
	@Test
	public void testBaseLoggingFatal(){
		logger.log(Level.FATAL, "Logueamos 4");
	}
}
