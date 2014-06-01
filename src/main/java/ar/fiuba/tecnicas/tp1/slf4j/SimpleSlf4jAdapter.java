package ar.fiuba.tecnicas.tp1.slf4j;

import org.slf4j.Logger;
import org.slf4j.helpers.MarkerIgnoringBase;

import ar.fiuba.tecnicas.tp1.factory.LoggerFactory;
import ar.fiuba.tecnicas.tp1.factory.SimpleLoggerFactory;
import ar.fiuba.tecnicas.tp1.logger.Level;

/**
 * Adaptador para utilizar al logger como binding de slf4j
 * Se ignora las funcionalidades de Marker 
 */
public class SimpleSlf4jAdapter extends MarkerIgnoringBase implements Logger{
	
	/**
	 * @TODO pensar la posibilidad de serializar a json
	 */
	
	private static final long serialVersionUID = -5468598022858541621L;
	
	private static final String TWO_OBJECTS_SEPARATOR=";";
	
	private ar.fiuba.tecnicas.tp1.logger.Logger logger;
	
	public SimpleSlf4jAdapter(){
		LoggerFactory factory = new SimpleLoggerFactory();
		logger=factory.createLogger();
	}

	public String getName() {
		return logger.getLoggerName();
	}

	public boolean isTraceEnabled() {
		return !logger.skipLogging(Level.TRACE);
	}

	public void trace(String msg) {
		logger.trace(msg);		
	}

	public void trace(String format, Object arg) {
		logger.log(Level.TRACE, arg.toString(), format);
		
	}

	public void trace(String format, Object arg1, Object arg2) {
		logger.log(Level.TRACE, arg1.toString()+TWO_OBJECTS_SEPARATOR+arg2.toString(), format);
		
	}

	public void trace(String format, Object... arguments) {
		logger.log(Level.TRACE, concatenateToString(arguments), format);		
	}

	public void trace(String msg, Throwable t) {
		logger.log(Level.TRACE, msg, t);
		
	}

	public boolean isDebugEnabled() {
		return !logger.skipLogging(Level.DEBUG);
	}

	public void debug(String msg) {
		logger.debug(msg);
	}

	public void debug(String format, Object arg) {
		logger.log(Level.DEBUG, arg.toString(), format);		
	}

	public void debug(String format, Object arg1, Object arg2) {
		logger.log(Level.DEBUG, arg1.toString()+TWO_OBJECTS_SEPARATOR+arg2.toString(), format);		
	}

	public void debug(String format, Object... arguments) {
		logger.log(Level.TRACE, concatenateToString(arguments), format);		
	}

	public void debug(String msg, Throwable t) {
		logger.log(Level.DEBUG, msg, t);		
	}

	public boolean isInfoEnabled() {
		return !logger.skipLogging(Level.INFO);
	}

	public void info(String msg) {
		logger.info(msg);		
	}

	public void info(String format, Object arg) {
		logger.log(Level.INFO, arg.toString(), format);		
	}

	public void info(String format, Object arg1, Object arg2) {
		logger.log(Level.INFO, arg1.toString()+TWO_OBJECTS_SEPARATOR+arg2.toString(), format);		
	}

	public void info(String format, Object... arguments) {
		logger.log(Level.INFO, concatenateToString(arguments), format);		
	}

	public void info(String msg, Throwable t) {
		logger.log(Level.INFO, msg, t);
	}

	public boolean isWarnEnabled() {
		return !logger.skipLogging(Level.WARN);
	}

	public void warn(String msg) {
		logger.warn(msg);
	}

	public void warn(String format, Object arg) {
		logger.log(Level.WARN, arg.toString(), format);		
	}

	public void warn(String format, Object... arguments) {
		logger.log(Level.WARN, concatenateToString(arguments), format);		
	}

	public void warn(String format, Object arg1, Object arg2) {
		logger.log(Level.WARN, arg1.toString()+TWO_OBJECTS_SEPARATOR+arg2.toString(), format);		
	}

	public void warn(String msg, Throwable t) {
		logger.log(Level.WARN, msg, t);
	}

	public boolean isErrorEnabled() {
		return !logger.skipLogging(Level.ERROR);
	}

	public void error(String msg) {
		logger.error(msg);
	}

	public void error(String format, Object arg) {
		logger.log(Level.ERROR, arg.toString(), format);		
	}

	public void error(String format, Object arg1, Object arg2) {
		logger.log(Level.ERROR, arg1.toString()+TWO_OBJECTS_SEPARATOR+arg2.toString(), format);		
	}

	public void error(String format, Object... arguments) {
		logger.log(Level.ERROR, concatenateToString(arguments), format);		
	}

	public void error(String msg, Throwable t) {
		logger.log(Level.ERROR, msg, t);
	}
	
	private static String concatenateToString(Object... objects){
		StringBuffer sb = new StringBuffer();
		for (Object object : objects) {
			sb.append(object.toString());
			sb.append(TWO_OBJECTS_SEPARATOR);
		}
		return sb.toString();		
	}
}
