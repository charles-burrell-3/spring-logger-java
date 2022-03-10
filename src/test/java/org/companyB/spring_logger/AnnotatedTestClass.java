package org.companyB.spring_logger;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class AnnotatedTestClass implements TestClass{
    @Logger(name = "log4J")
    private org.apache.logging.log4j.Logger lo4jLogger;
    @Logger
    private org.slf4j.Logger slf4jLogger;

    public void log(){
        lo4jLogger.info(message);
        slf4jLogger.info(message);
    }
}
