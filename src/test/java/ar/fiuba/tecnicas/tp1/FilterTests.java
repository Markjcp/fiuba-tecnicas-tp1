package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.CustomFilter;
import ar.fiuba.tecnicas.tp1.logger.CustomFilterBuilder;
import ar.fiuba.tecnicas.tp1.logger.SimpleFilter;
import ar.fiuba.tecnicas.tp1.logger.SimpleLogMessage;

public class FilterTests {
	
	public SimpleFilter filter;
	public SimpleLogMessage logMessage;
	public String stringMessage;
	HashMap<String, String> slicedMessage;
	public CustomFilter customFilter;

	@Before
	public void setUp() throws Exception {
		this.stringMessage = "En la vida hay cosas mas importantes que el dinero, pero cuestan mucho";
		this.filter = new SimpleFilter("message");
		this.slicedMessage = new HashMap<String, String>(); 
		this.slicedMessage.put("message", stringMessage);
		this.logMessage = new SimpleLogMessage(slicedMessage);
	}

	@Test
	public void messagePassesFilterTest() {
		this.filter.setFilterRegex("En(.*)");
		assertEquals(this.filter.applyFilter(this.logMessage), true);
	}

	@Test
	public void messageDoesNotPassFilterTest() {
		this.filter.setFilterRegex("P(.*)");
		assertEquals(this.filter.applyFilter(this.logMessage), false);
	}
	
	@Test
	public void messagePassesCustomFilterTest() {
		this.customFilter = (new CustomFilterBuilder()).setFilterByMessage("En(.*)").build();
		assertEquals(this.customFilter.applyFilter(logMessage), true);
	}
	
	@Test
	public void messageDoesNotPassCustomFilterTest() {
		this.customFilter = (new CustomFilterBuilder()).setFilterByMessage("P(.*)").build();
		assertEquals(this.customFilter.applyFilter(logMessage), false);
	}
}
