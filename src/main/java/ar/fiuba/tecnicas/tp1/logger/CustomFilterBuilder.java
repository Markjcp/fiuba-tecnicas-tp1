package ar.fiuba.tecnicas.tp1.logger;

public class CustomFilterBuilder {

	private CustomFilter customFilter;
	
	public CustomFilterBuilder() {
		this.customFilter = new CustomFilter();
	}
	
	public CustomFilterBuilder setFilterByDate(String dateFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("date", dateFilter));
		return this;
	}
	
	public CustomFilterBuilder setFilterByLevel(String levelFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("level", levelFilter));
		return this;
	}
	
	public CustomFilterBuilder setFilterByThread(String threadFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("thread", threadFilter));
		return this;
	}
	
	public CustomFilterBuilder setFilterByMessage(String messageFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("message", messageFilter));
		return this;
	}
	
	public CustomFilterBuilder setFilterByLineNumber(String lineNumberFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("line", lineNumberFilter));
		return this;
	}
	
	public CustomFilterBuilder setFilterByFileName(String fileNameFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("File Name", fileNameFilter));
		return this;
	}
	
	public CustomFilterBuilder setFilterByMethodName(String methodNameFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("Method Name", methodNameFilter));
		return this;
	}
	
	public CustomFilter build() {
		return customFilter;
	}
}
