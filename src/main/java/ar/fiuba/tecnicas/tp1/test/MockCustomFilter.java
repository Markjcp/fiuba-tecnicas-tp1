package ar.fiuba.tecnicas.tp1.test;

import ar.fiuba.tecnicas.tp1.logger.CustomFilter;
import ar.fiuba.tecnicas.tp1.logger.CustomFilterBuilder;

public class MockCustomFilter {
	
	public static CustomFilter getCustomFilter() {
		return (new CustomFilterBuilder()
		.setFilterByDate("(.*)/10/19(.*)").setFilterByMessage("En(.*)").build());
	}
}
