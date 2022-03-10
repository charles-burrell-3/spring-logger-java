package io.github.charles_burrell_3.spring_logger;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class FinalMemberTestClass implements TestClass{
    @Logger(name = "log4J")
    private final org.apache.logging.log4j.Logger lo4jLogger = null;
    @Logger
    private final org.slf4j.Logger slf4jLogger = null;

    public void log(){
        lo4jLogger.info(message);
        slf4jLogger.info(message);
    }
}
