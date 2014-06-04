package ar.fiuba.tecnicas.tp1.logger;

public class CustomFilterBuilder {

	private CustomFilter customFilter;
	
	public CustomFilterBuilder() {
		this.customFilter = new CustomFilter();
	}
	
	public CustomFilter setFilterByDate(String dateFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("Date", dateFilter));
		return customFilter;
	}
	
	public CustomFilter setFilterByLevel(String levelFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("Level", levelFilter));
		return customFilter;
	}
	
	public CustomFilter setFilterByThread(String threadFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("Thread", threadFilter));
		return customFilter;
	}
	
	public CustomFilter setFilterByMessage(String messageFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("Message", messageFilter));
		return customFilter;
	}
	
	public CustomFilter setFilterByLineNumber(String lineNumberFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("LineNumber", lineNumberFilter));
		return customFilter;
	}
	
	public CustomFilter setFilterByFileName(String fileNameFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("FileName", fileNameFilter));
		return customFilter;
	}
	
	public CustomFilter setFilterByMethodName(String methodNameFilter) {
		this.customFilter.setFilter((Filter)new SimpleFilter("MethodName", methodNameFilter));
		return customFilter;
	}
	
	public CustomFilter build() {
		return customFilter;
	}
}
