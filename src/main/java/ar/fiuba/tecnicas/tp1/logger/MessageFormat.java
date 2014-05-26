package ar.fiuba.tecnicas.tp1.logger;

import java.util.Arrays;
import java.util.Vector;

import static ar.fiuba.tecnicas.tp1.factory.CreationConstants.*;

/**
 * Esta clase se encarga de parsear el formato a partir de un string.
 * Puede definirse un separador para delimitar los diferentes formatos armados.
 *
 */
public class MessageFormat {
	
	private Vector<String> format;
	private String delimiter;
	
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
	
	/**
	 * Método que obtiene la cantidad de formatos aplicados.
	 * @return Cantidad de elementos de formato.
	 */
	public int getModifiersSize(){
		return format.size();
	}
	
	/**
	 * Método que devuelve el separador definido en el archivo de propiedades.
	 * @return Separador.
	 */
	public String getDelimiter() {
		return this.delimiter;
	}
	
	/**
	 * Método que obtiene el formato de fecha seleccionado en el archivo de propiedades.
	 * @return Formato de la fecha.
	 */
	public String getDateFormat() {
		int resultFoundCode = dateIsVisible();
		if(resultFoundCode!=NOT_FOUND_FORMAT_CODE){
			String element = this.format.elementAt(resultFoundCode);
			return element.substring(element.indexOf('{') + 1, element.indexOf('}'));
		}
		return "";
	}
	
	/**
	 * Comprueba si en el formato se especificó la fecha (es decir, contiene un %d) 
	 * para ser mostrada en el mensaje de log
	 * @return La posición de la fecha en la que deberia aparecer en el mensaje. 
	 */
	public int dateIsVisible() {
		int i = 0;
		for (String current : format) {
			if ((current.startsWith("%d{")) && 
					(current.indexOf('}') == current.length() - 1)) {
				return i;
			}
			i++;
		}
		return NOT_FOUND_FORMAT_CODE;
	}
	
	/**
	 * Comprueba si en el formato se especificó el nivel (es decir, contiene un %p) 
	 * para ser mostrada en el mensaje de log
	 * @return Si encuentra o no el formato de nivel
	 */
	public int levelIsVisible() {
		return this.format.contains("%p") ? this.format.indexOf("%p") : NOT_FOUND_FORMAT_CODE;
	}
	
	/**
	 * Comprueba si en el formato se especificó el thread (es decir, contiene un %t) 
	 * para ser mostrada en el mensaje de log
	 * @return Si encuentra o no el formato de thread
	 */
	public int threadIsVisible() {
		return this.format.contains("%t") ? this.format.indexOf("%t") : NOT_FOUND_FORMAT_CODE;
	}
	
	/**
	 * Comprueba si en el formato se especificó el mensaje (es decir, contiene un %m) 
	 * para ser mostrada en el mensaje de log
	 * @return Si encuentra o no el formato de mensaje
	 */
	public int messageIsVisible() {
		return this.format.contains("%m") ? this.format.indexOf("%m") : NOT_FOUND_FORMAT_CODE;
	}
	
	/**
	 * Comprueba si en el formato se especificó el delimitador (es decir, contiene un %n) 
	 * para ser mostrada en el mensaje de log
	 * @return Si encuentra o no el formato de delimitador
	 */
	public int delimiterIsVisible() {
		return this.format.contains("%n") ? this.format.indexOf("%n") : NOT_FOUND_FORMAT_CODE;
	}
	
	/**
	 * Comprueba si en el formato se especificó el numero de linea 
	 * (es decir, contiene un %L) para ser mostrada en el mensaje de log
	 * @return Si encuentra o no el formato de numero de linea
	 */
	public int lineNumberIsVisible() {
		return this.format.contains("%L") ? this.format.indexOf("%L") : NOT_FOUND_FORMAT_CODE;
	}
	
	/**
	 * Comprueba si en el formato se especificó el nombre del archivo 
	 * (es decir, contiene un %F) para ser mostrada en el mensaje de log
	 * @return Si encuentra o no el formato de nombre de archivo
	 */
	public int fileNameIsVisible() {
		return this.format.contains("%F") ? this.format.indexOf("%F") : NOT_FOUND_FORMAT_CODE;
	}
	
	/**
	 * Comprueba si en el formato se especificó el nombre del metodo 
	 * (es decir, contiene un %M) para ser mostrada en el mensaje de log
	 * @return Si encuentra o no el formato de nombre de metodo
	 */
	public int methodNameIsVisible() {
		return this.format.contains("%M") ? this.format.indexOf("%M") : NOT_FOUND_FORMAT_CODE;
	}
	
}
