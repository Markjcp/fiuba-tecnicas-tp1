package ar.fiuba.tecnicas.tp1.logger;

import java.util.Arrays;
import java.util.Vector;

import ar.fiuba.tecnicas.tp1.exceptions.FormatNotFoundException;

/**
 * Esta clase se encarga de parsear el formato de los mensajes a partir de un string.
 * Puede definirse un separador para delimitar los diferentes formatos armados o se utiliza
 * un default.
 *
 */
public class MessageFormat {
	
	private Vector<String> format;
	private String delimiter;
	private boolean jsonAvailable;
	
	/**
	 * Método que recibe un modifier pasado por parámetros (%p, %d, ..) y devuelve
	 * la posición donde se encuentra. Si no lo encuentra lanza una excepción unchecked
	 * @param modifier
	 * @return la posición donde se encuentra modifier en el formato 
	 */
	private int getIndexInFormat(String modifier) {
		if(this.format.contains(modifier)){
			return this.format.indexOf(modifier);
		}
		throw new FormatNotFoundException();		
	}
	
	/** Crea un MessageFormat a partir de un string y un delimitador.
	 * Para el formato del dia se aceptan los mismos que para SimpleDateFormat.
	 * Un ejemplo de formato podría ser: %d{HH:mm:ss} %p %t %m
	 * @param format
	 * @param delimiter
	 */
	public MessageFormat(String format, String delimiter) {
		this.delimiter = delimiter;
		this.format = new Vector<String>(Arrays.asList(format.split(delimiter)));
	}
	
	/** Crea un MessageFormat a partir de un string, un estilo y un delimitador.
	 * Para el formato del dia se aceptan los mismos que para SimpleDateFormat.
	 * Un ejemplo de formato podría ser: %d{HH:mm:ss} %p %t %m
	 * @param format
	 * @param delimiter
	 * @param formatStyle
	 */
	public MessageFormat(String format, String delimiter, boolean jsonAvailable) {
		this.delimiter = delimiter;
		this.format = new Vector<String>(Arrays.asList(format.split(delimiter)));
		this.jsonAvailable = jsonAvailable;
	}
	
	/**
	 * Método que obtiene la cantidad de formatos aplicados.
	 * @return Cantidad de elementos de formato.
	 */
	public int getModifiersSize(){
		return format.size();
	}
	
	/**
	 * Método que devuelve el separador definido en la configuracion.
	 * @return Separador.
	 */
	public String getDelimiter() {
		return this.delimiter;
	}
	
	/**
	 * Método que obtiene el formato de fecha seleccionado en el archivo de propiedades.
	 * @return Formato de la fecha o vacío si no existe.
	 */
	public String getDateFormat() {
		try {
			int resultFoundCode = getDateIndexInFormat();
			String element = this.format.elementAt(resultFoundCode);
			return element.substring(element.indexOf('{') + 1, element.indexOf('}'));
		} catch (FormatNotFoundException e) {
			return "";
		}		
	}
	
	/**
	 * Comprueba si en el formato se especificó la fecha (es decir, contiene un %d) 
	 * para ser mostrada en el mensaje de log. Si no lo encuentra lanza una excepción unchecked
	 * @return La posición de la fecha en la que deberia aparecer en el mensaje. 
	 */
	public int getDateIndexInFormat() {
		int i = 0;
		for (String current : format) {
			if ((current.startsWith("%d{")) && 
					(current.indexOf('}') == current.length() - 1)) {
				return i;
			}
			i++;
		}
		throw new FormatNotFoundException();
	}
	
	/**
	 * Comprueba si en el formato se especificó el nivel (es decir, contiene un %p) 
	 * para ser mostrada en el mensaje de log
	 * @return La posición en el formato del nivel o NOT_FOUND_FORMAT_CODE sino.
	 */
	public int getlevelIndexInFormat() {
		return getIndexInFormat("%p");
	}
	
	/**
	 * Comprueba si en el formato se especificó el thread (es decir, contiene un %t) 
	 * para ser mostrada en el mensaje de log
	 * @return La posición en el formato del thread o NOT_FOUND_FORMAT_CODE sino.
	 */
	public int getThreadIndexInFormat() {
		return getIndexInFormat("%t");
	}
	
	/**
	 * Comprueba si en el formato se especificó el mensaje (es decir, contiene un %m) 
	 * para ser mostrada en el mensaje de log
	 * @return La posición en el formato del mensaje o NOT_FOUND_FORMAT_CODE sino.
	 */
	public int getMessageIndexInFormat() {
		return getIndexInFormat("%m");
	}
	
	/**
	 * Comprueba si en el formato se especificó el numero de linea 
	 * (es decir, contiene un %L) para ser mostrada en el mensaje de log
	 * @return La posición en el formato del número de línea o NOT_FOUND_FORMAT_CODE.
	 */
	public int getLineNumberIndexInFormat() {
		return getIndexInFormat("%L");
	}
	
	/**
	 * Comprueba si en el formato se especificó el nombre del archivo 
	 * (es decir, contiene un %F) para ser mostrada en el mensaje de log
	 * @return La posición en el formato del nombre del archivo o NOT_FOUND_FORMAT_CODE
	 */
	public int getFileNameIndexInFormat() {
		return getIndexInFormat("%F");
	}
	
	/**
	 * Comprueba si en el formato se especificó el nombre del método 
	 * (es decir, contiene un %M) para ser mostrada en el mensaje de log
	 * @return La posición en el formatl del nombre del método o NOT_FOUND_FORMAT_CODE
	 */
	public int getMethodNameIndexInFormat() {
		return getIndexInFormat("%M");
	}
	
	/**
	 * Comprueba si en el formato se especificó el nombre de la clase
	 * (es decir, contiene un %g) para ser mostrada en el mensaje de log
	 * @return La posición en el formatl del nombre de la clase o NOT_FOUND_FORMAT_CODE
	 */
	public int getClassNameIndexInFormat() {
		return getIndexInFormat("%g");
	}

	public boolean isJsonAvailable() {
		return jsonAvailable;
	}

	public void setJsonAvailable(boolean jsonAvailable) {
		this.jsonAvailable = jsonAvailable;
	}	
}
