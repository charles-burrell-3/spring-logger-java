package io.github.charles_burrell_3.spring_logger;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class InvalidMemberTestClass implements TestClass{
    @Logger
    private static final org.apache.logging.log4j.Logger lo4jLogger = null;

    @Override
    public void log() {
        lo4jLogger.info(message);
    }
}
