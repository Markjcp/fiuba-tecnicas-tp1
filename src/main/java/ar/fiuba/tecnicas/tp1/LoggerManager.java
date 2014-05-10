package ar.fiuba.tecnicas.tp1;

import java.util.HashMap;
import java.util.Map;

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

	public LoggerFactory getFactory() {
		return factory;
	}

	public void setFactory(LoggerFactory factory) {
		this.factory = factory;
	}	

}
