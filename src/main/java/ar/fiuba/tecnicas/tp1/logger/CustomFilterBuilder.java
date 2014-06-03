package ar.fiuba.tecnicas.tp1.logger;

public class CustomFilterBuilder {

	private CustomFilter customFilter;
	
	public CustomFilterBuilder() {
		this.customFilter = new CustomFilter();
	}
	
	public CustomFilter setFilterByDate(String dateFilter) {
		this.customFilter.setFilter("Date", dateFilter);
		return customFilter;
	}
	
	public CustomFilter setFilterByLevel(String levelFilter) {
		this.customFilter.setFilter("Level", levelFilter);
		return customFilter;
	}
	
	public CustomFilter build() {
		return customFilter;
	}
}
