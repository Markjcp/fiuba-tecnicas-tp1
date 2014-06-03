package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.logger.SimpleFilter;

public class FilterTests {
	
	public SimpleFilter filter;
	public String message1;
	public String message2;
	public String message3;
	public String message4;

	@Before
	public void setUp() throws Exception {
		this.filter = new SimpleFilter();
		this.message1 = "En la vida hay cosas mas importantes que el dinero, pero cuestan mucho";
		this.message2 = "Mientras llegas a tu destino, disfruta del camino";
		this.message3 = "El que busca la verdad corre el riesgo de encontrarla.";
		this.message4 = "";
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
