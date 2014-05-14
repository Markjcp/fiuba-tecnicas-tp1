package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.MessageFormat;


public class FormatTests {

	@Test
	public void testLevelIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p", "-");
		assertEquals(mf.levelIsVisible(), true);
	}

	@Test
	public void testLevelIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%M", "-");
		assertEquals(mf.levelIsVisible(), false);
	}
	
	@Test
	public void threadIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%t-%L%", "-");
		assertEquals(mf.threadIsVisible(), true);
	}

	@Test
	public void threadIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%L", "-");
		assertEquals(mf.threadIsVisible(), false);
	}

	@Test
	public void lineNumberIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.lineNumberIsVisible(), true);
	}

	@Test
	public void lineNumberIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p", "-");
		assertEquals(mf.lineNumberIsVisible(), false);
	}

	@Test
	public void fileNameIsVisible() {
		MessageFormat mf = new MessageFormat("%F-%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.fileNameIsVisible(), true);
	}

	@Test
	public void fileNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%M", "-");
		assertEquals(mf.fileNameIsVisible(), false);
	}

	@Test
	public void methodNameIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.methodNameIsVisible(), true);
	}

	@Test
	public void methodNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%L", "-");
		assertEquals(mf.methodNameIsVisible(), false);
	}
}
