package org.companyB.spring_logger.provider.impl;

import org.companyB.spring_logger.provider.LoggerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * SLF4J Implementation of LoggerFactory
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class Slf4jLoggerProvider implements LoggerProvider<Logger> {
    private static Slf4jLoggerProvider slf4jLoggerProvider;
    /** Private constructor for limiting access **/
    private Slf4jLoggerProvider(){}
    /**
     * @return Instance of this class.
     * @since 1.0
     */
    public static Slf4jLoggerProvider get(){
        if(null == slf4jLoggerProvider){
            slf4jLoggerProvider = new Slf4jLoggerProvider();
        }
        return slf4jLoggerProvider;
    }

    @Override
    public Logger logger(String loggerName) {
        return LoggerFactory.getLogger(loggerName);
    }
}
