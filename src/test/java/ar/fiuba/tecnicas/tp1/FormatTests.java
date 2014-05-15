package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.MessageFormat;

import static ar.fiuba.tecnicas.tp1.factory.CreationConstants.*;

public class FormatTests {

	@Test
	public void testLevelIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p", "-");
		assertEquals(mf.levelIsVisible() != NOT_FOUND_FORMAT_CODE, true);
	}

	@Test
	public void testLevelIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%M", "-");
		assertEquals(mf.levelIsVisible() != NOT_FOUND_FORMAT_CODE, false);
	}

	@Test
	public void testThreadIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%t-%L%", "-");
		assertEquals(mf.threadIsVisible() != NOT_FOUND_FORMAT_CODE, true);
	}

	@Test
	public void testThreadIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%L", "-");
		assertEquals(mf.threadIsVisible() != NOT_FOUND_FORMAT_CODE, false);
	}

	@Test
	public void testLineNumberIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.lineNumberIsVisible() != NOT_FOUND_FORMAT_CODE, true);
	}

	@Test
	public void testLineNumberIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p", "-");
		assertEquals(mf.lineNumberIsVisible() != NOT_FOUND_FORMAT_CODE, false);
	}

	@Test
	public void testFileNameIsVisible() {
		MessageFormat mf = new MessageFormat("%F-%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.fileNameIsVisible() != NOT_FOUND_FORMAT_CODE, true);
	}

	@Test
	public void testFileNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%M", "-");
		assertEquals(mf.fileNameIsVisible() != NOT_FOUND_FORMAT_CODE, false);
	}

	@Test
	public void testMethodNameIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.methodNameIsVisible() != NOT_FOUND_FORMAT_CODE, true);
	}

	@Test
	public void testMethodNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%L", "-");
		assertEquals(mf.methodNameIsVisible() != NOT_FOUND_FORMAT_CODE, false);
	}

}
