package io.github.charles_burrell_3.spring_logger;

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
