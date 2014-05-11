package ar.fiuba.tecnicas.tp1.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	
	public static Properties loadProperties() throws IOException{
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("defaultProperties");
		defaultProps.load(in);
		in.close();
		return defaultProps;
		
	}

}