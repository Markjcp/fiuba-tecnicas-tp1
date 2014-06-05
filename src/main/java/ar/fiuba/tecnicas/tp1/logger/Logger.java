package ar.fiuba.tecnicas.tp1.logger;

import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

/**
 * Clase que representa a un logger
 *
 */
public class Logger {

	private LoggerConfigurable configuration;
	
	private MessageFormatApplier messageFormatApplier;
	
	private FilterManager filters = new FilterManager();
	
	public void addFilter(Filter filter) {
		this.filters.addFilter(filter);
	}
	
	public void removeFilter(Filter filter) {
		this.filters.removeFilter(filter);
	}
	
	public boolean isLoggable(LogMessage message) {
		return this.filters.messageOvercomesFilters(message);
	}

	public Logger(LoggerConfigurable configuration) {
		super();
		this.configuration = configuration;
		this.messageFormatApplier = new MessageFormatApplier(configuration.getFormat());
	}
	
	public LoggerConfigurable getConfigurationCopy(){
		return configuration.copy();
	}
	
	/**
	 * Obtiene de forma estática un logger 
	 * @param aClass una clase
	 * @return el Logger obtenido desde otra invocación
	 */
	public static Logger getLogger(Class<?> aClass) {
		return getLogger(aClass.getName());
	}

	/**
	 * Obtiene de forma estática un logger a través del LoggerManager
	 * @param name el nombre del logger a obtener
	 * @return el logger solicitado y uno nuevo si no lo encontró
	 */
	public static Logger getLogger(String name) {
		return LoggerManager.getInstance().getLogger(name);
	}

	/**
	 * Método para loguear cierto mensaje 
	 * @param level el nivel del mensaje a loguear
	 * @param message el mensaje a loguear
	 */
	public void log(Level level, String message) {
		log(level, new SimpleLogMessage(message, messageFormatApplier.buildMessage(
			message, level, getLoggerName())));
	}
	
	/**
	 * Método para loguear cierto mensaje con otro formato
	 * @param level el nivel del mensaje a loguear
	 * @param message el mensaje a loguear
	 * @param format el nuevo formato
	 */
	public void log(Level level, String message, String format) {
		MessageFormat anotherFormat = new MessageFormat(format, this.configuration.getSeparator());
		MessageFormatApplier anotherApplier = new MessageFormatApplier(anotherFormat);
		log(level, new SimpleLogMessage(message, anotherApplier.buildMessage(
			message, level, getLoggerName())));
	}
	
	/**
	 * Método para loguear cierto mensaje 
	 * @param level el nivel del mensaje a loguear
	 * @param message el mensaje a loguear
	 * @param t el throwable de donde se tomara la descripción
	 */
	public void log(Level level, String message, Throwable t){
		log(level, new SimpleLogMessage(message + " " + t.getMessage(), 
			messageFormatApplier.buildMessage(message, level, getLoggerName())));
	}

	/**
	 * Determinación si se debe loguear o no dependiendo del nivel pasado y configurado
	 * @param level el nivel a loguear 
	 * @return verdadero si debería escapar ese log, falso en caso contrario
	 */
	public boolean skipLogging(Level level) {
		return !configuration.isEnabled()
				|| level.compareTo(configuration.getLevel()) < 0;
	}

	/**
	 * Método para loguear cierto mensaje representado por un objeto
	 * @param level el nivel del mensaje a loguear
	 * @param message el mensaje a loguear
	 */
	public void log(Level level, LogMessage message) {
		LogMessage lastFormattedMessage = 
			new SimpleLogMessage(messageFormatApplier.getLastFormattedMessage());  
		if (skipLogging(level) || 
				!this.isLoggable(lastFormattedMessage)) {
			return;
		}
		List<LoggerAppender> appenders = configuration.getLoggerAppenders();
		for (LoggerAppender loggerAppender : appenders) {
			loggerAppender.doLog(message);
		}
	}
	
	/**
	 * Retrieve logger name
	 * @return the logger name
	 */
	public String getLoggerName(){
		return LoggerManager.getInstance()
		.getLoggerName(this);
	}
	
	/* Métodos para cada nivel de log*/
	
	public void trace(String message){
		log(Level.TRACE, message);
	}
	
	public void debug(String message){
		log(Level.DEBUG,message);
	}

	public void info(String message) {
		log(Level.INFO, message);
	}

	public void info(LogMessage message) {
		log(Level.INFO, message);
	}

	public void warn(String message) {
		log(Level.WARN, message);
	}

	public void warn(LogMessage message) {
		log(Level.WARN, message);
	}

	public void error(String message) {
		log(Level.ERROR, message);
	}

	public void error(LogMessage message) {
		log(Level.ERROR, message);
	}

	public void fatal(String message) {
		log(Level.FATAL, message);
	}

	public void fatal(LogMessage message) {
		log(Level.FATAL, message);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((configuration == null) ? 0 : configuration.hashCode());
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
		Logger other = (Logger) obj;
		if (configuration == null) {
			if (other.configuration != null)
				return false;
		} else if (!configuration.equals(other.configuration))
			return false;
		return true;
	}
	
	

}
