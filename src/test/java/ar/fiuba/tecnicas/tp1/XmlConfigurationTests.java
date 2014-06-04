package ar.fiuba.tecnicas.tp1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.tecnicas.tp1.appenders.ConsoleAppender;
import ar.fiuba.tecnicas.tp1.factory.CreationConstants;
import ar.fiuba.tecnicas.tp1.logger.Level;
import ar.fiuba.tecnicas.tp1.logger.Logger;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfigurable;
import ar.fiuba.tecnicas.tp1.logger.LoggerConfiguration;
import ar.fiuba.tecnicas.tp1.xml.ConfigurationXmlBuilder;
import ar.fiuba.tecnicas.tp1.xml.ConfigurationXmlWrapper;
import ar.fiuba.tecnicas.tp1.xml.CustomAppenderXmlWrapper;
import ar.fiuba.tecnicas.tp1.xml.CustomAppenderXmlWrapperParam;
import ar.fiuba.tecnicas.tp1.xml.FileAppenderXmlWrapper;
import ar.fiuba.tecnicas.tp1.xml.LoggerConfigurationAdapter;

public class XmlConfigurationTests {

	private ConfigurationXmlWrapper comparition;

	private ConfigurationXmlWrapper mockComparition;
	
	private LoggerConfigurable config;

	@Before
	public void setup() {
		List<CustomAppenderXmlWrapper> customAppenders = new ArrayList<CustomAppenderXmlWrapper>();
		CustomAppenderXmlWrapper customAppender = new CustomAppenderXmlWrapper();
		customAppender
				.setClassName("ar.fiuba.tecnicas.tp1.appenders.SimpleCustomAppender");
		List<CustomAppenderXmlWrapperParam> customAppenderParams = new ArrayList<CustomAppenderXmlWrapperParam>();
		CustomAppenderXmlWrapperParam param1 = new CustomAppenderXmlWrapperParam();
		param1.setKey("param1");
		param1.setValue("Custom Appender Info:");
		CustomAppenderXmlWrapperParam param2 = new CustomAppenderXmlWrapperParam();
		param1.setKey("param2");
		param1.setValue("Unimportant");
		customAppenderParams.add(param1);
		customAppenderParams.add(param2);
		customAppender.setParams(customAppenderParams);
		customAppenders.add(customAppender);

		List<FileAppenderXmlWrapper> fileAppenders = new ArrayList<FileAppenderXmlWrapper>();
		FileAppenderXmlWrapper fileAppender1 = new FileAppenderXmlWrapper();
		FileAppenderXmlWrapper fileAppender2 = new FileAppenderXmlWrapper();
		FileAppenderXmlWrapper fileAppender3 = new FileAppenderXmlWrapper();
		fileAppender1.setFileName("/home/marcos/log0.txt");
		fileAppender2.setFileName("/home/marcos/log1.txt");
		fileAppender3.setFileName("/home/marcos/log2.txt");
		fileAppenders.add(fileAppender1);
		fileAppenders.add(fileAppender2);
		fileAppenders.add(fileAppender3);
		comparition = new ConfigurationXmlWrapper();
		comparition.setConsole(true);
		comparition.setFormat("%m-%d{HH:mm:ss}-%t-%p-%L-%F-%M");
		comparition.setLevel("INFO");
		comparition.setSeparator("-");
		comparition.setCustomAppenders(customAppenders);
		comparition.setFileAppenders(fileAppenders);

		mockComparition = new ConfigurationXmlWrapper();
		mockComparition.setConsole(true);
		mockComparition.setFormat("%m");
		mockComparition.setLevel("ERROR");
		mockComparition.setSeparator("-");
		
		config = new LoggerConfiguration();
		config.setFormat("%m");
		config.setLevel(Level.ERROR);
		config.setSeparator("-");
		config.addAppender(new ConsoleAppender());
	}

	@Test
	public void testCorrectXmlLoading() {
		ConfigurationXmlWrapper wrapper = ConfigurationXmlBuilder
				.build(CreationConstants.XML_CONFIGURATION_FILE);
		assertEquals(wrapper, comparition);
	}

	@Test
	public void testWrongXmlLoading() {
		ConfigurationXmlWrapper wrapper = ConfigurationXmlBuilder
				.build(CreationConstants.XML_CONFIGURATION_FILE);
		comparition.setSeparator("");
		assertEquals(wrapper.equals(comparition), false);
	}
	
	@Test
	public void testConfigurationFromXmlWrapper(){
		assertEquals(LoggerConfigurationAdapter.adaptFromXmlWrapper(mockComparition), config);
	}

	@Test
	public void testLoggerFromXmlWrapper() {
		
		Logger logger1 = new Logger(config);
		Logger logger2 = new Logger(
				LoggerConfigurationAdapter.adaptFromXmlWrapper(mockComparition));
		assertEquals(logger1, logger2);
	}
}
