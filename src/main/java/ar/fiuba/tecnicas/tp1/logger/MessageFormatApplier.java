package ar.fiuba.tecnicas.tp1.logger;

import static ar.fiuba.tecnicas.tp1.factory.CreationConstants.NOT_FOUND_FORMAT_CODE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase se encarga de aplicar el formato que obtiene de MessageFormat a un 
 * mensaje de log en particular. 
 *
 */
public class MessageFormatApplier {
		
	private MessageFormat messageFormat;
	
	/**
	 * Constructor que a partir de un formato y un delimitador, devuelve un 
	 * MessageFormatApplier
	 * @param format
	 * @param delimiter
	 */
	public MessageFormatApplier(String format, String delimiter) {
		this.messageFormat = new MessageFormat(format, delimiter);
	}
	
	/**
	 * Método que devuelve el mensaje formateado según el formato especificado en 
	 * el archivo de propiedades.
	 * @param message
	 * @param level
	 * @param loggerName
	 * @return mensaje formateado.
	 */
	public String buildMessage(String message, Level level, String loggerName){
		int size = messageFormat.getModifiersSize();
		String[] modifiers = new String[size];
		int dateIndex = messageFormat.dateIsVisible();
		if( dateIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[dateIndex]= getDate();
		}
		int levelIndex = messageFormat.levelIsVisible();
		if( levelIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[levelIndex]=getLevel(level);
		}
		int threadIndex = messageFormat.threadIsVisible();
		if( threadIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[threadIndex]=getCurrentThread();
		}
		int messageIndex = messageFormat.messageIsVisible();
		if( messageIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[messageIndex]=getMessage(message);
		}
		int lineNumberIndex = messageFormat.lineNumberIsVisible();
		if( lineNumberIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[lineNumberIndex]= getLineNumber();
		}
		int fileNameIndex = messageFormat.fileNameIsVisible();
		if( fileNameIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[fileNameIndex]=getFileName(loggerName);
		}
		int methodNameIndex = messageFormat.methodNameIsVisible();
		if (methodNameIndex != NOT_FOUND_FORMAT_CODE){
			modifiers[methodNameIndex]= getMethodName();
		}
		String result="";
		for (String modifier : modifiers) {
			if(!modifier.isEmpty()){
				result += modifier + " " + getDelimiter() + " ";				
			}
		}
		if(!result.equals("")){
			result=result.substring(0, result.length() - getDelimiter().length() -2);
		}
		return result;
		
	}
	
	/**
	 * Método que devuelve la fecha según el formato que obtuvo el MessageFormat.
	 * Si no se especificó la fecha en el formato, entonces se devuelve un string vacío.
	 * @return fecha formateada si corresponde.
	 */
	private String getDate() {
		if (!this.messageFormat.getDateFormat().isEmpty()) {
			DateFormat dateFormat = new SimpleDateFormat(this.messageFormat.getDateFormat());
			return dateFormat.format(new Date());
		}
		return "";
	}
	
	/**
	 * Método que devuelve el nivel según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el nivel en el formato, entonces se devuelve un string vacío.
	 * @param level
	 * @return nivel del mensaje si corresponde
	 */
	private String getLevel(Level level) {
		return this.messageFormat.levelIsVisible()!=NOT_FOUND_FORMAT_CODE?level.toString():"";
	}
	
	/**
	 * Método que devuelve el thread según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el thread en el formato, entonces se devuelve un string vacío.
	 * @return thread actual de donde se está loggeando si corresponde
	 */
	private String getCurrentThread() {
		return this.messageFormat.threadIsVisible()!=NOT_FOUND_FORMAT_CODE ? 
				Thread.currentThread().getName() : "";
	}
	
	/**
	 * Método que devuelve el número de línea según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el número de línea en el formato, entonces se devuelve un string vacío.
	 * @return número de linea actual si corersponde
	 */
	private String getLineNumber() {
		return this.messageFormat.lineNumberIsVisible()!=NOT_FOUND_FORMAT_CODE ? 
				String.valueOf(Thread.currentThread().getStackTrace()[4].getLineNumber()) : "";
	}
	
	/**
	 * Método que devuelve el nombre del archivo según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el nombre del archivo en el formato, 
	 * entonces se devuelve un string vacío.
	 * @param fileName
	 * @return nombre del archivo si corresponde
	 */
	private String getFileName(String fileName) {
		return this.messageFormat.fileNameIsVisible()!=NOT_FOUND_FORMAT_CODE?fileName:"";
	}
	
	/**
	 * Método que devuelve el nombre del método según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el nombre del método en el formato, 
	 * entonces se devuelve un string vacío.
	 * @return nombre del método si corresponde
	 */
	private String getMethodName() {
		return this.messageFormat.methodNameIsVisible()!=NOT_FOUND_FORMAT_CODE ? 
				Thread.currentThread().getStackTrace()[4].getMethodName() : "";
	}
	
	/**
	 * Método que devuelve el mensaje según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el mensaje en el formato, entonces se devuelve un string vacío.
	 * @param message
	 * @return mensaje ingresado por el usuario si corresponde
	 */
	private String getMessage(String message) {
		return this.messageFormat.messageIsVisible()!=NOT_FOUND_FORMAT_CODE ? message : "";
	}
	
	/**
	 * Método que devuelve el delimitador según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el delimitador en el formato, entonces se devuelve un string vacío.
	 * @return delimitador definido en el archivo de propiedades
	 */
	private String getDelimiter() {
		return this.messageFormat.getDelimiter();
	}
}
