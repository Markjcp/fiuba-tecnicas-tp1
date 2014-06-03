package ar.fiuba.tecnicas.tp1.logger;

public interface Filter {
	
	/**
	 * Aplica el filtro al mensaje y decide si lo deja pasar o no.
	 * @param message
	 * @return Si el mensaje pasa el filtro o no.
	 */
	public boolean applyFilter(String message);
}
