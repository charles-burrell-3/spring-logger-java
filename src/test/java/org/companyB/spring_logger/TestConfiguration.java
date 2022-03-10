package org.companyB.spring_logger;

import org.companyB.spring_logger.processor.LoggerAnnotationProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
@Configuration
public class TestConfiguration {
    @Bean
    public TestClass testClass(){
        return new AnnotatedTestClass();
    }
    @Bean
    public LoggerAnnotationProcessor loggerAnnotationProcessor(){
        return new LoggerAnnotationProcessor();
    }
}
