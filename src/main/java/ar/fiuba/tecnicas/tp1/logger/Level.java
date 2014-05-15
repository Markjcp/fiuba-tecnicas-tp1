package ar.fiuba.tecnicas.tp1.logger;

import java.util.HashMap;
import java.util.Map;

public final class Level implements Comparable<Level> {
	
	public static final Level OFF;

	public static final Level INFO;

	public static final Level WARN;

	public static final Level ERROR;

	public static final Level FATAL;

	private final int intLevel;
	
	private static Map<String,Level> levels;
	private static Map<Integer,String> names;

	static {
		levels = new HashMap<String, Level>();
		names = new HashMap<Integer, String>();
		OFF = new Level(10000);
		levels.put("OFF", OFF);
		names.put(10000,"OFF");
		INFO = new Level(1000);
		levels.put("INFO", INFO);
		names.put(1000, "INFO");
		WARN = new Level(2000);
		levels.put("WARN", WARN);
		names.put(2000, "WARN");
		ERROR = new Level(3000);
		levels.put("ERROR", ERROR);
		names.put(3000, "ERROR");
		FATAL = new Level(4000);
		levels.put("FATAL", FATAL);
		names.put(4000, "FATAL");
	}

	public Level(int intLevel) {
		super();
		this.intLevel = intLevel;
	}

	public int compareTo(Level other) {
		return intLevel < other.intLevel ? -1 : (intLevel > other.intLevel ? 1
				: 0);
	}
	
	public static Level getLevelFromString(String levelName){
		return levels.get(levelName);
	}

	@Override
	public String toString() {
		return names.get(this.intLevel);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intLevel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (intLevel != other.intLevel)
			return false;
		return true;
	}
}
