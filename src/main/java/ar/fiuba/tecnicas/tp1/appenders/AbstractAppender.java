package ar.fiuba.tecnicas.tp1.appenders;

public abstract class AbstractAppender {
	
	private boolean logged = false;

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}
