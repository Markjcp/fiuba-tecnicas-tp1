package ar.fiuba.tecnicas.tp1.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  Clase que se encarga de cargar un Property a través de un archivo
 *
 */
public class PropertyLoader {
	
	public static Properties loadProperties(String source) throws IOException{
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream(source);
		defaultProps.load(in);
		in.close();
		return defaultProps;
		
	}

}
