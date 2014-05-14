package ar.fiuba.tecnicas.tp1.logger;

import java.util.HashMap;
import java.util.Map;

import ar.fiuba.tecnicas.tp1.factory.LoggerFactory;
import ar.fiuba.tecnicas.tp1.factory.SimpleLoggerFactory;

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
	
	public Logger getLogger(String name){
		Logger result= loggers.get(name);
		if(result!=null){
			return result;
		}
		if(factory==null){
			factory=new SimpleLoggerFactory();
		}
		return factory.createLogger();
	}
	
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

}
