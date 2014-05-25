package ar.fiuba.tecnicas.tp1.logger;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

/**
 * Implementación de la interfaz de configuración de Loggger en forma de beans 
 */
public class LoggerConfiguration implements LoggerConfigurable {

	private Level level;

	private boolean enabled = true;

	private List<LoggerAppender> appenders;
	
	private String format;
	
	private String separator;

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean isEnabled() {
		return enabled && (level!=null && !level.equals(Level.OFF));
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addAppender(LoggerAppender appender) {
		if (appenders == null) {
			appenders = new ArrayList<LoggerAppender>();
		}
		appenders.add(appender);
	}

	public List<LoggerAppender> getLoggerAppenders() {
		return appenders;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;		
	}
	
	public LoggerConfigurable copy() {
		LoggerConfigurable result = new LoggerConfiguration();
		result.setFormat(this.format);
		result.setLevel(this.level);
		result.setSeparator(this.separator);
		for (LoggerAppender appender : this.appenders) {
			result.addAppender(appender);
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((appenders == null) ? 0 : appenders.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result
				+ ((separator == null) ? 0 : separator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoggerConfiguration other = (LoggerConfiguration) obj;
		if (appenders == null) {
			if (other.appenders != null)
				return false;
		} else if (appenders.size()!=other.appenders.size())
			return false;
		if (enabled != other.enabled)
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (separator == null) {
			if (other.separator != null)
				return false;
		} else if (!separator.equals(other.separator))
			return false;
		return true;
	}
}
