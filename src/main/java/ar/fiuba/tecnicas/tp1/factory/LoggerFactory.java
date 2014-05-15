package ar.fiuba.tecnicas.tp1.factory;

import ar.fiuba.tecnicas.tp1.logger.Logger;

/**
 * Interfaz que define el comportamiento de un creador de loggers
 */
public interface LoggerFactory {
	
	Logger createLogger();

}
