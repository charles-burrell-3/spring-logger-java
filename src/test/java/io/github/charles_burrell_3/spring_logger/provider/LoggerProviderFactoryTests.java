package io.github.charles_burrell_3.spring_logger.provider;

import io.github.charles_burrell_3.spring_logger.provider.impl.Log4jLoggerProvider;
import io.github.charles_burrell_3.spring_logger.provider.impl.Slf4jLoggerProvider;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class LoggerProviderFactoryTests {

    @Test
    public void testGetLog4jLoggerProvider(){
        final Class<org.apache.logging.log4j.Logger> _class = org.apache.logging.log4j.Logger.class;
        final Optional loggerProvider = LoggerProviderFactory.loggerProvider(_class);
        assertTrue(loggerProvider.isPresent());
        assertTrue(loggerProvider.get() instanceof Log4jLoggerProvider);
    }

    @Test
    public void testGetSlf4jLoggerProvider(){
        final Class<org.slf4j.Logger> _class = org.slf4j.Logger.class;
        final Optional loggerProvider = LoggerProviderFactory.loggerProvider(_class);
        assertTrue(loggerProvider.isPresent());
        assertTrue(loggerProvider.get() instanceof Slf4jLoggerProvider);
    }

    @Test
    public void testGetNonExistentLogger(){
        final Class<String> _class = String.class;
        final Optional loggerProvider = LoggerProviderFactory.loggerProvider(_class);
        assertFalse(loggerProvider.isPresent());
    }
}
