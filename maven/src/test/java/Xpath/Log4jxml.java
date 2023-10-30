package Xpath;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jxml {

	public static void main(String[] args) {

		Logger log=Logger.getLogger(Log4jxml.class);
		
		DOMConfigurator.configure("log4j.xml");
		log.info("This is start1");
		log.error("This is error");
		log.fatal("This is fatal");
		log.debug("This is debug");
		log.warn("This is warning");
	}

}
