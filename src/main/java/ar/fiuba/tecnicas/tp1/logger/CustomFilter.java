package ar.fiuba.tecnicas.tp1.logger;

import java.util.Hashtable;

public class CustomFilter implements Filter {

	private Hashtable<String, String> filters;
	
	public CustomFilter() {
		this.filters = new Hashtable<String, String>();
	}
	
	public boolean applyFilter(LogMessage message) {
		return true;
	}
	
	public void setFilter(String modifier, String filter) {
		filters.put(modifier, filter);
	}
}
