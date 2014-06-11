package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.appenders.ConsoleAppender;
import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.exceptions.FormatNotFoundException;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfiguration;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurationBuilder;
import ar.fiuba.tecnicas.tp1.logger.MessageFormat;
import ar.fiuba.tecnicas.tp1.logger.MessageFormatApplier;

public class FormatTests {

	@Test
	public void testLevelIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%p", "-");
		assertEquals(mf.getlevelIndexInFormat(),1);		
	}

	@Test(expected=FormatNotFoundException.class)
	public void testLevelIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%M", "-");
		mf.getlevelIndexInFormat();
	}

	@Test
	public void testThreadIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%p-%t-%L%", "-");
		assertEquals(mf.getThreadIndexInFormat(),2);		
	}

	@Test(expected=FormatNotFoundException.class)
	public void testThreadIsNotVisible() {
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%p-%L", "-");
		mf.getThreadIndexInFormat();
	}

	@Test
	public void testLineNumberIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%p-%M-%L", "-");
		assertEquals(mf.getLineNumberIndexInFormat(), 3);
	}

	@Test(expected=FormatNotFoundException.class)
	public void testLineNumberIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p", "-");
		mf.getLineNumberIndexInFormat();
	}

	@Test
	public void testFileNameIsVisible() {
		MessageFormat mf = new MessageFormat("%F-%d{dd:MM:yy}-%p-%M-%L", "-");
		assertEquals(mf.getFileNameIndexInFormat(), 0);
	}

	@Test(expected=FormatNotFoundException.class)
	public void testFileNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%M", "-");
		mf.getFileNameIndexInFormat();
	}

	@Test
	public void testMethodNameIsVisible() {
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%p-%M-%L", "-");
		assertEquals(mf.getMethodNameIndexInFormat(), 2);
	}
	
	@Test
	public void testClassNameIsVisisble() {
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%p-%M-%L-%g", "-");
		assertEquals(mf.getClassNameIndexInFormat(), 4);
	}

	@Test(expected=FormatNotFoundException.class)
	public void testMethodNameIsNotVisible() {
		MessageFormat mf = new MessageFormat("%p-%L", "-");
		mf.getMethodNameIndexInFormat();
	}
	
	@Test
	public void testJSONFormatStyle() {
		List<LoggerAppender> appenders;
		appenders = new ArrayList<LoggerAppender>();
		appenders.add(new ConsoleAppender());
		
		LoggerConfigurationBuilder builder = new LoggerConfigurationBuilder();
		LoggerConfiguration conf1 = builder.setAppenders(appenders)
				.setEnabled(true).setFormat("%m").setLevel(Level.INFO)
				.setSeparator("-").build();
		MessageFormat mf = new MessageFormat("%d{dd:MM:yy}-%p-%M-%L-%g", "-",true);
		conf1.setFormat(mf);
		conf1.addAppender(new ConsoleAppender());
		
		MessageFormatApplier mfa = new MessageFormatApplier(mf);
		Logger logger2 = new Logger(conf1);
		String jsonString = mfa.buildMessage("Logger JSON format", Level.INFO, logger2.getLoggerName());
		
		boolean value = true;
		
		try {
	        JSONObject json = new JSONObject(jsonString);
	    } catch (JSONException e) {
	    	assertEquals(false,value);
	    }
		assertEquals(true,value);	
		
	}

}
