package ar.fiuba.tecnicas.tp1.logger;

public class SimpleFilter implements Filter {
	
	private String filterRegex; 
	
	public SimpleFilter(String filterRegex){
		this.filterRegex = filterRegex;
	}
	
	public SimpleFilter() {
		this.filterRegex = "";
	}
	
	public boolean applyFilter(String message) {
		return this.filterRegex.isEmpty() ? true : message.matches(this.filterRegex);
	}
	
	public void setFilterRegex(String filterRegex){
		this.filterRegex = filterRegex;
	}
}
