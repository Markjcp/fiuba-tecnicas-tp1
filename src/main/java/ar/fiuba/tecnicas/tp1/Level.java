package ar.fiuba.tecnicas.tp1;

public final class Level implements Comparable<Level> {
	
	public static final Level OFF;

	public static final Level INFO;

	public static final Level WARN;

	public static final Level ERROR;

	public static final Level FATAL;

	private final int intLevel;

	static {
		OFF = new Level(0);
		INFO = new Level(1000);
		WARN = new Level(2000);
		ERROR = new Level(3000);
		FATAL = new Level(4000);
	}

	public Level(int intLevel) {
		super();
		this.intLevel = intLevel;
	}

	public int compareTo(Level other) {
		return intLevel < other.intLevel ? -1 : (intLevel > other.intLevel ? 1
				: 0);
	}

}
