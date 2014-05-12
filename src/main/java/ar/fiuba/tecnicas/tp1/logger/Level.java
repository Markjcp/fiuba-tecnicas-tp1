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

	static {
		levels = new HashMap<String, Level>();
		OFF = new Level(10000);
		levels.put("OFF", OFF);
		INFO = new Level(1000);
		levels.put("INFO", INFO);
		WARN = new Level(2000);
		levels.put("WARN", WARN);
		ERROR = new Level(3000);
		levels.put("ERROR", ERROR);
		FATAL = new Level(4000);
		levels.put("FATAL", FATAL);
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

}
