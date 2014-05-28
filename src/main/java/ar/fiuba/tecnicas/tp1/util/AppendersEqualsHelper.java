package ar.fiuba.tecnicas.tp1.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

/**
 * Clase utilitaria que realiza la comparación entre dos listas de appenders
 */
public class AppendersEqualsHelper {

	/**
	 * Define si dos listas de appenders son iguales
	 * 
	 * @param first
	 *            primer lista
	 * @param second
	 *            segunda lista
	 * @return verdadero si existe la misma cantidad de instancias de appenders
	 *         en cada lista, falso en caso contrario
	 */
	public static boolean areAppendersEqual(List<LoggerAppender> first,
			List<LoggerAppender> second) {
		if (first == null || second == null) {
			return false;
		}
		if (first.size() != second.size()) {
			return false;
		}
		Map<Class<? extends LoggerAppender>, Integer> firstMap = retrieveMapFromCollection(first);
		Map<Class<? extends LoggerAppender>, Integer> secondMap = retrieveMapFromCollection(second);

		for (Class<? extends LoggerAppender> key : firstMap.keySet()) {
			if (secondMap.get(key) == null
					|| !secondMap.get(key).equals(firstMap.get(key))) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Genera un mapa de conteo de interfaces appender
	 * 
	 * @param appenders
	 *            la lista de appenders
	 * @return el mapa con los conteos
	 */
	private static Map<Class<? extends LoggerAppender>, Integer> retrieveMapFromCollection(
			List<LoggerAppender> appenders) {
		Map<Class<? extends LoggerAppender>, Integer> result = new HashMap<Class<? extends LoggerAppender>, Integer>();
		for (LoggerAppender loggerAppender : appenders) {
			result.put(
					loggerAppender.getClass(),
					result.get(loggerAppender.getClass()) == null ? 0 : result
							.get(loggerAppender.getClass()) + 1);
		}
		return result;
	}
}
