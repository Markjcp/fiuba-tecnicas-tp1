package ar.fiuba.tecnicas.tp1.logger;

import java.util.Vector;

public class CustomFilter implements Filter {

	private Vector<Filter> filters;
	
	public CustomFilter() {
		this.filters = new Vector<Filter>();
	}
	
	public boolean applyFilter(LogMessage message) {
		for (int i = 0; i < filters.size(); i++) {
			if (filters.elementAt(i).applyFilter(message) == false)
				return false;
		}
		return true;
	}
	
	public void setFilter(Filter filter) {
		this.filters.add(filter);
	}
}
