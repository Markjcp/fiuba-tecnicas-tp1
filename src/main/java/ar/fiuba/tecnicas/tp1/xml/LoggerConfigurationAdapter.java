package ar.fiuba.tecnicas.tp1.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.fiuba.tecnicas.tp1.appenders.ConsoleAppender;
import ar.fiuba.tecnicas.tp1.appenders.CustomLoggerAppender;
import ar.fiuba.tecnicas.tp1.appenders.FileAppender;
import ar.fiuba.tecnicas.tp1.exceptions.LoadConfigurationException;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfiguration;

/**
 * Adapta el bean wrapper de xml a la interfaz de configuración utilizada en la
 * api
 */
public class LoggerConfigurationAdapter {

	/**
	 * Adaptador
	 * 
	 * @param xmlWrapper
	 *            el bean wrapper del xml
	 * @return el objeto adaptado
	 */
	public static LoggerConfigurable adaptFromXmlWrapper(
			ConfigurationXmlWrapper xmlWrapper) {
		LoggerConfigurable result = new LoggerConfiguration();
		result.setFormat(xmlWrapper.getFormat());
		result.setLevel(Level.getLevelFromString(xmlWrapper.getLevel()));
		result.setSeparator(xmlWrapper.getSeparator());
		if(xmlWrapper.isJson()){
			result.enableJsonFormat();
		}
		if (xmlWrapper.isConsole()) {
			result.addAppender(new ConsoleAppender());
		}
		if (xmlWrapper.getFileAppenders() != null) {
			for (FileAppenderXmlWrapper fileWrapper : xmlWrapper
					.getFileAppenders()) {
				result.addAppender(new FileAppender(fileWrapper.getFileName()));
			}
		}
		if (xmlWrapper.getCustomAppenders() != null) {
			for (CustomAppenderXmlWrapper customWrapper : xmlWrapper
					.getCustomAppenders()) {
				try {
					CustomLoggerAppender toInsert = (CustomLoggerAppender) Class
							.forName(customWrapper.getClassName())
							.newInstance();
					List<CustomAppenderXmlWrapperParam> params = customWrapper
							.getParams();
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					if (params != null) {
						for (CustomAppenderXmlWrapperParam customAppenderXmlWrapperParam : params) {
							paramsMap.put(
									customAppenderXmlWrapperParam.getKey(),
									customAppenderXmlWrapperParam.getValue());
						}
					}
					toInsert.loadAppenderParameters(paramsMap);
					result.addAppender(toInsert);
				} catch (Exception e) {
					throw new LoadConfigurationException();
				}
			}
		}
		return result;
	}

}
