package org.companyB.spring_logger.processor;

import io.vavr.control.Try;
import org.companyB.spring_logger.TestClass;
import org.companyB.spring_logger.TestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
public class LoggerAnnotationProcessorSpringTests {
    @Autowired
    private TestClass testClass;

    @Test
    public void testSpring(){
        assertTrue(Try.of(() -> {
            testClass.log();
            return true;
        }).isSuccess());
    }
}
