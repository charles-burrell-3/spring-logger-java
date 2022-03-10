package org.companyB.spring_logger.processor;

import io.vavr.control.Try;
import org.companyB.spring_logger.AnnotatedTestClass;
import org.companyB.spring_logger.TestClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class LoggerAnnotationProcessorTests {

    private LoggerAnnotationProcessor processor;
    private final String BEAN_NAME = "this";

    @BeforeEach
    public void setup() {
        processor = new LoggerAnnotationProcessor();
    }

    @Test
    public void testPostProcessBeforeInitialization() {
        testPostProcess(true,
                (bean, beanName) -> processor.postProcessBeforeInitialization(bean, beanName));
    }

    @Test
    public void testPostProcessAfterInitialization(){
        testPostProcess(false,
                (bean, beanName) -> processor.postProcessAfterInitialization(bean, beanName));
    }

    private void testPostProcess(final boolean invocationSuccessExpected,
                                 final BiFunction<Object, String, Object> function){
        final Try<Boolean> attempt = Try.of( ()-> {
            final TestClass beforeProcessing = new AnnotatedTestClass();
            final TestClass afterProcessing =
                    (TestClass) function.apply(beforeProcessing, BEAN_NAME);
            afterProcessing.log();
            return true;
        });
        assertEquals(invocationSuccessExpected, attempt.isSuccess());
    }
}
