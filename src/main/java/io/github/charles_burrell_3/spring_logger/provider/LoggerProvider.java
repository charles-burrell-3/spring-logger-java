package io.github.charles_burrell_3.spring_logger.provider;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * Interface for utilities that will provide the instances of the Logger class for the annotated field.
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public interface LoggerProvider <Logger>{
    /**
     * @param loggerName Name of the logger that will be bound to a specific field.
     * @return Logger to bind to field.
     * @since 1.0
     */
    Logger logger(final String loggerName);
}
