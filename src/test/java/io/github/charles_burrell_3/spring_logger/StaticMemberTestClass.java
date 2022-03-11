package io.github.charles_burrell_3.spring_logger;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class StaticMemberTestClass implements TestClass{
    @Logger(name = "log4J")
    private static org.apache.logging.log4j.Logger lo4jLogger;
    @Logger
    private static org.slf4j.Logger slf4jLogger;

    public void log(){
        lo4jLogger.info(message);
        slf4jLogger.info(message);
    }
}
