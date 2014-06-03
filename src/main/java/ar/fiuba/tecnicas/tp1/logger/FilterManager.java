package ar.fiuba.tecnicas.tp1.logger;

import java.util.Vector;

public class FilterManager {
	
	private Vector<Filter> filters = new Vector<Filter>();

	public void addFilter(Filter filter) {
		this.filters.add(filter);
	}
	
	public void removeFilter(Filter filter) {
		this.filters.remove(filter);
	}
	
	public boolean messageOvercomesFilters(LogMessage message) {
		for (int i = 0; i < this.filters.size(); i++) {
			if (this.filters.elementAt(i).applyFilter(message) == false) {
				return false;
			}
		}
		return true;
	}

}
