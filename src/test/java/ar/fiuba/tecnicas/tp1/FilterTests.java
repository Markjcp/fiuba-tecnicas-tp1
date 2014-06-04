package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.SimpleFilter;
import ar.fiuba.tecnicas.tp1.logger.SimpleLogMessage;

public class FilterTests {
	
	public SimpleFilter filter;
	public SimpleLogMessage message1;
	public SimpleLogMessage message2;
	public SimpleLogMessage message3;
	public SimpleLogMessage message4;

	@Before
	public void setUp() throws Exception {
		this.filter = new SimpleFilter("Message");
		this.message1 = new SimpleLogMessage("En la vida hay cosas mas importantes que el dinero, pero cuestan mucho");
		this.message2 = new SimpleLogMessage("Mientras llegas a tu destino, disfruta del camino");
		this.message3 = new SimpleLogMessage("El que busca la verdad corre el riesgo de encontrarla.");
		this.message4 = new SimpleLogMessage("");
	}

	@Test
	public void messagePassesFilterTest() {
		this.filter.setFilterRegex("En(.*)");
		assertEquals(this.filter.applyFilter(this.message1), true);
	}

	@Test
	public void messageDoesNotPassFilterTest() {
		this.filter.setFilterRegex("P(.*)");
		assertEquals(this.filter.applyFilter(this.message1), false);
	}

}
