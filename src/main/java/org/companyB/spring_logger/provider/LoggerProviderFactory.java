package org.companyB.spring_logger.provider;

import io.vavr.API;
import org.companyB.spring_logger.provider.impl.Log4jLoggerProvider;
import org.companyB.spring_logger.provider.impl.Slf4jLoggerProvider;

import java.util.Optional;
import static io.vavr.API.*;
/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * Factory that provides a concrete implementation of @link LoggerProvider.
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class LoggerProviderFactory {

    private static final String LOG4J = org.apache.logging.log4j.Logger.class.getCanonicalName();
    private static final String SLF4J = org.slf4j.Logger.class.getCanonicalName();

    /**
     * Returns an instance of the LoggerProvider for one of the following loggers:
     * <ol>
     *     <li>org.apache.logging.log4j.Logger</li>
     *     <li>org.slf4j.Logger</li>
     * </ol>
     * @param loggerClass Class
     * @return Logger Provider implementation.
     */
    public static Optional<LoggerProvider<?>> loggerProvider(
            final Class<?>loggerClass){
        return Match(loggerClass.getCanonicalName()).of(
                API.Case($(LOG4J), Optional.of(Log4jLoggerProvider.get())),
                Case($(SLF4J), Optional.of(Slf4jLoggerProvider.get())),
                Case($(),Optional.empty())
        );
    }
}
