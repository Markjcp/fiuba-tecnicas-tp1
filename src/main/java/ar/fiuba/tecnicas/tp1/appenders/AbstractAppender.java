package ar.fiuba.tecnicas.tp1.appenders;

/**
 * Clase padre para reunir funcionalidad común a todos los appenders
 * Se incluye para testear en principio
 */
public abstract class AbstractAppender {

	private boolean logged = false;

	/**
	 * Comprueba si se utilizó esta instancia para loguear alguna vez
	 * @return verdadero si se utilizó, falso en caso contrario
	 */
	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		return getClass() != obj.getClass();

	}

}
