package ar.fiuba.tecnicas.tp1.factory;

public interface CreationConstants {

	public static final String DEFAULT_CONFIGURATION_FILE = "log-config.properties";

	public static final String DEFAULT_LOG_OUTPUT_FILE = "/home/marcos/log.txt";
	
	public static final String FILE_APPENDER_KEY= "logger.appender.file";
	
	public static final String CONSOLE_APPENDER_KEY= "logger.appender.console";
	
	public static final String LEVEL_KEY = "logger.level";
	
	public static final String FORMAT_KEY = "logger.message.format";
	
	public static final String SEPARATOR_KEY = "logger.message.separator";

}
