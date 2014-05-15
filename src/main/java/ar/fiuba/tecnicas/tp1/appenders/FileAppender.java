package ar.fiuba.tecnicas.tp1.appenders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ar.fiuba.tecnicas.tp1.exceptions.AppendException;
import ar.fiuba.tecnicas.tp1.logger.LogMessage;

/**
 * Appender para loguear por archivo
 *
 */
public class FileAppender implements LoggerAppender {

	private String fileName;
	
	private String appenderName;

	public FileAppender(String fileName) {
		super();
		this.fileName = fileName;
	}

	/**
	 * Método de la interfaz LoggerAppender que definimitavamente realiza el log
	 */
	public void doLog(LogMessage message) {
		try {

			File file = new File(fileName);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(message.getFormattedMessage());
			bw.newLine();
			bw.close();

		} catch (IOException e) {
			throw new AppendException("Error writing in file");
		}

	}

	public String getAppenderName() {
		return appenderName;
	}

	public void setAppenderName(String appenderName) {
		this.appenderName = appenderName;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof FileAppender;
	}

}
