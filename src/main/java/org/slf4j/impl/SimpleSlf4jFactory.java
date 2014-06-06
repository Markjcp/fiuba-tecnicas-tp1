package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class SimpleSlf4jFactory implements ILoggerFactory {

	public Logger getLogger(String name) {
		ar.fiuba.tecnicas.tp1.logger.Logger mainLogger = ar.fiuba.tecnicas.tp1.logger.Logger
				.getLogger(name);
		return new SimpleSlf4jAdapter(mainLogger);
	}
}
