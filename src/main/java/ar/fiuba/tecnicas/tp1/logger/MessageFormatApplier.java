package ar.fiuba.tecnicas.tp1.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.fiuba.tecnicas.tp1.exceptions.FormatNotFoundException;

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
	 * Constructor que a partir de un MessageFormat devuelve un
	 * MessageFormatApplier
	 */
	public MessageFormatApplier(MessageFormat format) {
		this.messageFormat = format;
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
		try {
			int dateIndex = messageFormat.getDateIndexInFormat();
			modifiers[dateIndex]= getDate();
		} catch (FormatNotFoundException unimportant) {}
		
		try {
			int levelIndex = messageFormat.getlevelIndexInFormat();
			modifiers[levelIndex]=getLevel(level);
		} catch (FormatNotFoundException unimportant) {}
		
		try {
			int threadIndex = messageFormat.getThreadIndexInFormat();
			modifiers[threadIndex]=getCurrentThread();
		} catch (FormatNotFoundException unimportant) {}
		
		try {
			int messageIndex = messageFormat.getMessageIndexInFormat();
			modifiers[messageIndex]=getMessage(message);
		} catch (FormatNotFoundException unimportant) {}
		
		try {
			int lineNumberIndex = messageFormat.getLineNumberIndexInFormat();
			modifiers[lineNumberIndex]= getLineNumber();
		} catch (FormatNotFoundException unimportant) {}
		
		try {
			int fileNameIndex = messageFormat.getFileNameIndexInFormat();
			modifiers[fileNameIndex]=getFileName(loggerName);
		} catch (FormatNotFoundException unimportant) {}
		
		try {
			int methodNameIndex = messageFormat.getMethodNameIndexInFormat();
			modifiers[methodNameIndex]= getMethodName();
		} catch (FormatNotFoundException unimportant) {}
		
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
	 * Si no se especificó el formato de la fecha en el formato, entonces se utiliza un
	 * formato default.
	 * @return fecha formateada.
	 */
	private String getDate() {
		DateFormat dateFormat = new SimpleDateFormat(this.messageFormat.getDateFormat());
		return dateFormat.format(new Date());
	}
	
	/**
	 * Método que devuelve el nivel según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el nivel en el formato, entonces se devuelve un string vacío.
	 * @param level
	 * @return nivel del mensaje si corresponde
	 */
	private String getLevel(Level level) {
		return level.toString();
	}
	
	/**
	 * Método que devuelve el thread según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el thread en el formato, entonces se devuelve un string vacío.
	 * @return thread actual de donde se está loggeando si corresponde
	 */
	private String getCurrentThread() {
		return Thread.currentThread().getName();
	}
	
	/**
	 * Método que devuelve el número de línea según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el número de línea en el formato, entonces se devuelve un string vacío.
	 * @return número de linea actual si corersponde
	 */
	private String getLineNumber() {
		return String.valueOf(Thread.currentThread().getStackTrace()[4].getLineNumber());
	}
	
	/**
	 * Método que devuelve el nombre del archivo según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el nombre del archivo en el formato, 
	 * entonces se devuelve un string vacío.
	 * @param fileName
	 * @return nombre del archivo si corresponde
	 */
	private String getFileName(String fileName) {
		return fileName;
	}
	
	/**
	 * Método que devuelve el nombre del método según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el nombre del método en el formato, 
	 * entonces se devuelve un string vacío.
	 * @return nombre del método si corresponde
	 */
	private String getMethodName() {
		return Thread.currentThread().getStackTrace()[4].getMethodName();
	}
	
	/**
	 * Método que devuelve el mensaje según el formato que obtuvo el MessageFormat.
	 * Si no se especificó el mensaje en el formato, entonces se devuelve un string vacío.
	 * @param message
	 * @return mensaje ingresado por el usuario si corresponde
	 */
	private String getMessage(String message) {
		return message;
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
