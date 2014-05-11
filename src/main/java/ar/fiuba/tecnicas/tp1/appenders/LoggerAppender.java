package ar.fiuba.tecnicas.tp1.appenders;

import ar.fiuba.tecnicas.tp1.logger.LogMessage;

public interface LoggerAppender {
	void doLog(LogMessage message);
}
