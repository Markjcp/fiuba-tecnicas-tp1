package ar.fiuba.tecnicas.tp1.logger;

public class SimpleFilter implements Filter {
	
	private String filterRegex;
	
	private String filterName;

	private String getMessageSlice(LogMessage message) {
		String slice = "";
		if (filterName == "Message") {
			slice = message.getMessage();
		}
		return slice;
	}

	public SimpleFilter(String filterName){
		this.filterName = filterName;
	}

	public SimpleFilter(String filterName, String filterRegex){
		this.filterName = filterName;
		this.filterRegex = filterRegex;
	}
	
	public boolean applyFilter(LogMessage message) {
		String messageSlice = getMessageSlice(message);
		return this.filterRegex.isEmpty() ? true : 
			messageSlice.matches(this.filterRegex);
	}
	
	public void setFilterRegex(String filterRegex){
		this.filterRegex = filterRegex;
	}
}
