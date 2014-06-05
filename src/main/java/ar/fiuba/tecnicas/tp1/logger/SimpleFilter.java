package ar.fiuba.tecnicas.tp1.logger;

import java.util.HashMap;

public class SimpleFilter implements Filter {
	
	private String filterRegex = "";
	
	private String filterName = "";

	private String getMessageSlice(LogMessage message) {
		HashMap<String,String> slicedMessage = message.getSlicedMessage();
		String slice = "";
		if (slicedMessage.containsKey(filterName)) {
			slice = slicedMessage.get(filterName);
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
