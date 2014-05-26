package ar.fiuba.tecnicas.tp1.appenders;

public abstract class AbstractAppender {

	private boolean logged = false;

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
