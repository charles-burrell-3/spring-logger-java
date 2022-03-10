package io.github.charles_burrell_3.spring_logger.provider.impl;

import io.github.charles_burrell_3.spring_logger.provider.LoggerProvider;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * Log4J implementation of LoggerProvider
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class Log4jLoggerProvider implements LoggerProvider<Logger> {
    private static Log4jLoggerProvider log4JLoggerProvider;
    /** Private constructor for limiting access **/
    private Log4jLoggerProvider(){}
    /**
     * @return Instance of this class.
     * @since 1.0
     */
    public static Log4jLoggerProvider get(){
        if(null == log4JLoggerProvider){
            log4JLoggerProvider = new Log4jLoggerProvider();
        }
        return log4JLoggerProvider;
    }
    @Override
    public Logger logger(final String loggerName) {
        return LogManager.getLogger(loggerName);
    }
}
