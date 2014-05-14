package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.MessageFormat;
import ar.fiuba.tecnicas.tp1.logger.MessageFormatApplier;


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
	public void testThreadIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%t-%L%", "-");
		assertEquals(mf.threadIsVisible(), true);
	}

	@Test
	public void testThreadIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%L", "-");
		assertEquals(mf.threadIsVisible(), false);
	}

	@Test
	public void testLineNumberIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.lineNumberIsVisible(), true);
	}

	@Test
	public void testLineNumberIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p", "-");
		assertEquals(mf.lineNumberIsVisible(), false);
	}

	@Test
	public void testFileNameIsVisible() {
		MessageFormat mf = new MessageFormat("%F-%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.fileNameIsVisible(), true);
	}

	@Test
	public void testFileNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%M", "-");
		assertEquals(mf.fileNameIsVisible(), false);
	}

	@Test
	public void testMethodNameIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd-MM-yy}-%p-%M-%L", "-");
		assertEquals(mf.methodNameIsVisible(), true);
	}

	@Test
	public void testMethodNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%L", "-");
		assertEquals(mf.methodNameIsVisible(), false);
	}
	
	@Test
	public void testApplyFormatGetDate() {
		MessageFormatApplier mfa = new MessageFormatApplier("%d{yyyy.MM.dd}", "-");
		//Falla el contains dentro de getDateFormat en MessageFormat
		System.out.println(mfa.applyFormat("Error"));
		assertEquals(mfa.applyFormat("Error"), "");
	}
}
