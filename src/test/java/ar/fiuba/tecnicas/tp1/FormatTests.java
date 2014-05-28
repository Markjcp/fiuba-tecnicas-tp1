package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.MessageFormat;
import static ar.fiuba.tecnicas.tp1.factory.CreationConstants.*;

public class FormatTests {

	@Test
	public void testLevelIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p", "-");
		assertNotEquals(mf.getlevelIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testLevelIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%M", "-");
		assertEquals(mf.getlevelIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testThreadIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%t-%L%", "-");
		assertNotEquals(mf.getThreadIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testThreadIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%L", "-");
		assertEquals(mf.getThreadIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testLineNumberIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertNotEquals(mf.getLineNumberIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testLineNumberIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p", "-");
		assertEquals(mf.getLineNumberIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testFileNameIsVisible() {
		MessageFormat mf = new MessageFormat("%F-%d{dd-MM-yy}-%p-%M-%L", "-");
		assertNotEquals(mf.getFileNameIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testFileNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%M", "-");
		assertEquals(mf.getFileNameIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testMethodNameIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertNotEquals(mf.getMethodNameIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

	@Test
	public void testMethodNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%L", "-");
		assertEquals(mf.getMethodNameIndexInFormat(), NOT_FOUND_FORMAT_CODE);
	}

}
