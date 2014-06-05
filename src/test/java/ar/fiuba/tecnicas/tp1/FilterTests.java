package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.CustomFilter;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.SimpleLogMessage;
import ar.fiuba.tecnicas.tp1.test.MockCustomFilter;
import ar.fiuba.tecnicas.tp1.test.MockFactory;
import ar.fiuba.tecnicas.tp1.test.MockSimpleFilter;

public class FilterTests {
	
	public MockSimpleFilter filter;
	public SimpleLogMessage logMessage1;
	public SimpleLogMessage logMessage2;
	public String stringMessage1;
	public String stringMessage2;
	public String stringDate;
	HashMap<String, String> slicedMessage1;
	HashMap<String, String> slicedMessage2;
	public CustomFilter customFilter;
	public Logger logger;
	
	public void buildSlicedMessage1() {		
		this.slicedMessage1 = new HashMap<String, String>();
		this.stringMessage1 = "En la vida hay cosas mas importantes que el dinero, pero cuestan mucho"; 
		this.slicedMessage1.put("message", this.stringMessage1);
		this.stringDate = "17/10/1989";
		this.slicedMessage1.put("date", this.stringDate);
	}
	
	public void buildSlicedMessage2() {		
		this.slicedMessage2 = new HashMap<String, String>();
		this.stringMessage2 = "Por muchos idiomas que se dominen, cuando uno se corta al afeitarse, siempre utiliza la lengua materna."; 
		this.slicedMessage2.put("message", this.stringMessage2);
		this.stringDate = "05/12/1989";
		this.slicedMessage2.put("date", this.stringDate);
	}

	@Before
	public void setUp() throws Exception {
		this.buildSlicedMessage1();
		this.buildSlicedMessage2();
		this.filter = new MockSimpleFilter();
		this.logMessage1 = new SimpleLogMessage(this.slicedMessage1);
		this.logMessage2 = new SimpleLogMessage(this.slicedMessage2);
		this.customFilter = MockCustomFilter.getCustomFilter();
		this.logger = new MockFactory().createLogger();
		this.logger.addFilter(new MockSimpleFilter());
		this.logger.addFilter(MockCustomFilter.getCustomFilter());
	}

	@Test
	public void messagePassesFilterTest() {
		this.filter.setFilterRegex("En(.*)");
		assertEquals(this.filter.applyFilter(this.logMessage1), true);
	}

	@Test
	public void messageDoesNotPassFilterTest() {
		this.filter.setFilterRegex("P(.*)");
		assertEquals(this.filter.applyFilter(this.logMessage1), false);
	}
	
	@Test
	public void messagePassesCustomFilterTest() {
		assertEquals(this.customFilter.applyFilter(logMessage1), true);
	}
	
	@Test
	public void messageDoesNotPassCustomFilterTest() {
		assertEquals(this.customFilter.applyFilter(logMessage2), false);
	}
	
	@Test
	public void messagePassesLogFilterTest() {
		assertEquals(this.logger.isLoggable(logMessage1), true);
	}
	
	@Test
	public void messageDoesNotPassLogFilterTest() {
		assertEquals(this.logger.isLoggable(logMessage2), false);
	}
}
