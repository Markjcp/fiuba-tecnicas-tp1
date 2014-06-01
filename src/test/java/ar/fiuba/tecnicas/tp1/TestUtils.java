package ar.fiuba.tecnicas.tp1;

import java.util.List;

import ar.fiuba.tecnicas.tp1.appenders.LoggerAppender;

public class TestUtils {

	public static boolean hasAppend(List<LoggerAppender> appenders) {
		for (LoggerAppender loggerAppender : appenders) {
			if (loggerAppender.hasLogged()) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean haveAllLoggersAppend(List<LoggerAppender> appenders) {
		for (LoggerAppender loggerAppender : appenders) {
			if (!loggerAppender.hasLogged()) {
				return false;
			}
		}
		return true;
	}
}
