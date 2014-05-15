package ar.fiuba.tecnicas.tp1.logger;

import java.util.HashMap;
import java.util.Map;

import ar.fiuba.tecnicas.tp1.factory.LoggerFactory;
import ar.fiuba.tecnicas.tp1.factory.SimpleLoggerFactory;

/**
 * Encargado de admnistrar los loggers. Singleton 
 *
 */
public class LoggerManager {
	
	private static LoggerManager instance;
	
	private LoggerFactory factory;
	
	private Map<String,Logger> loggers;
	
	private LoggerManager(){
		loggers=new HashMap<String, Logger>();		
	}
	
	public static synchronized LoggerManager getInstance(){
		if(instance==null){
			instance=new LoggerManager();
		}
		return instance;
	}
	
	/**
	 * Devuelve y crea loggers
	 * @param name nombre del logger a buscar o crear
	 * @return el logger creado si no existia con esa clave o el existente
	 */
	public Logger getLogger(String name){
		Logger result= loggers.get(name);
		if(result!=null){
			return result;
		}
		if(factory==null){
			factory=new SimpleLoggerFactory();
		}
		Logger newLogger= factory.createLogger();
		loggers.put(name, newLogger);
		return newLogger;
	}
	
	/**
	 * Devuelve el nombre de un logger almacenado
	 * @param aLogger logger a buscar
	 * @return el nombre del logger
	 */
	public String getLoggerName(Logger aLogger){
		for (String loggerKey : loggers.keySet()) {
			if(aLogger.equals(loggers.get(loggerKey))){
				return loggerKey;
			}
		}
		return null;
	}

	public void setFactory(LoggerFactory factory) {
		this.factory = factory;
	}	
	
	public boolean isLoggerRegistered(String name){
		return loggers.get(name)!=null;
	}

}
