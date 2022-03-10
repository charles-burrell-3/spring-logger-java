package org.companyB.spring_logger;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class NonAnnotatedTestClass implements TestClass{
    private org.apache.logging.log4j.Logger nonAnnotatedLog4JLogger;
    private org.slf4j.Logger nonAnnotatedSlf4jLogger;

    @Override
    public void log() {
        nonAnnotatedLog4JLogger.info(message);
        nonAnnotatedSlf4jLogger.info(message);
    }
}
