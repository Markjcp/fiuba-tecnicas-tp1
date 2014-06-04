package ar.fiuba.tecnicas.tp1.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import ar.fiuba.tecnicas.tp1.appenders.ConsoleAppender;
import ar.fiuba.tecnicas.tp1.appenders.CustomLoggerAppender;
import ar.fiuba.tecnicas.tp1.appenders.FileAppender;
import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;
import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;

public class PropertiesLoaderUtils {
	
	/**
	 * Valida si es una clave correcta para un appender de archivos
	 * @param key la clave
	 * @return verdadero si es correcta sino falso
	 */
	private static boolean isValidFileAppenderKey(String key) {
		return key.startsWith(CreationConstants.FILE_APPENDER_KEY)
				&& key.length() > CreationConstants.FILE_APPENDER_KEY.length();

	}

	/**
	 * Valida si es una clave correcta para un appender de consola
	 * @param key la clave
	 * @return verdadero si es correcta sino falso
	 */
	private static boolean isValidConsoleAppenderKey(String key) {
		return key.equals(CreationConstants.CONSOLE_APPENDER_KEY);

	}
	
	/**
	 * Valida si es una clave correcta para un appender custom
	 * @param key la clave
	 * @return verdadero si es correcta sino falso
	 */
	private static boolean isValidCustomAppenderKey(String key) {
		return key.startsWith(CreationConstants.CUSTOM_APPENDER_KEY)
				&& key.length() > CreationConstants.CUSTOM_APPENDER_KEY.length();

	}

	/**
	 * Metodo utilitario que obtiene el nombre del file appender
	 * @param prefix prefijo
	 * @param entireKey clave entera
	 * @return nombre del file appender
	 */
	private static String cutAppenderName(String prefix, String entireKey) {
		return entireKey.substring(prefix.length(), entireKey.length());
	}

	/**
	 * Carga los appenders de un property
	 * @param properties el property
	 * @return la lista de appenders
	 */
	public static List<LoggerAppender> loadAppendersFromProperties(
			Properties properties) {
		Set<Object> keys = properties.keySet();
		Map<String,Map<String,Object>> customAppendersParameters = new HashMap<String, Map<String,Object>>();
		List<LoggerAppender> result = new ArrayList<LoggerAppender>();
		boolean consoleFound = false;
		for (Object key : keys) {
			String keyStr = (String) key;
			if (isValidFileAppenderKey(keyStr)) {
				String appenderValue = properties.getProperty(keyStr);
				FileAppender fileAppender = new FileAppender(appenderValue);
				fileAppender.setAppenderName(cutAppenderName(
						CreationConstants.FILE_APPENDER_KEY, keyStr));
				result.add(fileAppender);
			} else if (!consoleFound && isValidConsoleAppenderKey(keyStr)) {
				String appenderValue = properties.getProperty(keyStr);
				if (Boolean.valueOf(appenderValue).booleanValue()) {
					consoleFound = true;
					result.add(new ConsoleAppender());
				}
			} else if(isValidCustomAppenderKey(keyStr)){
				String cutKey=cutAppenderName(CreationConstants.CUSTOM_APPENDER_KEY, keyStr);
				cutKey = cutKey.substring(1, cutKey.length());
				String[] cutKeyArray=cutKey.split("\\.");
				Map<String, Object> auxMap = customAppendersParameters.get(cutKeyArray[0]);
				if(auxMap == null){
					auxMap = new HashMap<String, Object>();
				}
				auxMap.put(cutKeyArray[1], properties.getProperty(keyStr));
				customAppendersParameters.put(cutKeyArray[0], auxMap);
			}
		}
		if(!customAppendersParameters.isEmpty()){
			for (String customAppenderParamsKey : customAppendersParameters.keySet()) {
				Map<String,Object> innerParams = customAppendersParameters.get(customAppenderParamsKey);
				String className = (String)innerParams.get(CreationConstants.CUSTOM_APPENDER_CLASS_KEY);
				if(className != null){
					try {
						CustomLoggerAppender customAppender = (CustomLoggerAppender)Class.forName(className).newInstance();
						customAppender.loadAppenderParameters(innerParams);
						result.add(customAppender);
					} catch (Exception e) {
						throw new LoadConfigurationException();
					}
					
				}
			}
		}
		return result;
	}

}
