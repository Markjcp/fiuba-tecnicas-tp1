package ar.fiuba.tecnicas.tp1;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.impl.StaticLoggerBinder;

public class BaseSl4jTests {

	private Logger logger;

	@Before
	public void setup() {
		logger = StaticLoggerBinder.getSingleton().getLoggerFactory()
				.getLogger(BaseSl4jTests.class.getName());

	}

	@Test
	public void testBaseLoggingInfo() {
		logger.info("Logueamos 1");
	}

	@Test
	public void testBaseLoggingWarn() {
		logger.warn("Logueamos 2");
	}

	@Test
	public void testBaseLoggingError() {
		logger.error("Logueamos 3");
	}
}
