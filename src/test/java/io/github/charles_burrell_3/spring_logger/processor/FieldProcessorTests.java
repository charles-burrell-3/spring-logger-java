package io.github.charles_burrell_3.spring_logger.processor;

import io.github.charles_burrell_3.spring_logger.*;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class FieldProcessorTests {
    @ParameterizedTest
    @MethodSource("params")
    public void processTests(TestClass testClass,
                             boolean decorationSucceeds,
                             boolean decorationResult,
                             boolean invocationSucceeds){
        final Either<String, Boolean> result = FieldProcessor.get().process(testClass);
        assertEquals(result.isRight(), decorationSucceeds);
        if(decorationSucceeds) assertEquals(result.get(), decorationResult);
        else assertFalse(result.getLeft().isEmpty());
        final Try<Boolean> attempt = Try.of(()-> {
            testClass.log();
            return true;
        });
        assertEquals(attempt.isSuccess(), invocationSucceeds);
    }

    private static Stream<Arguments> params(){
        return Stream.of(
                Arguments.of(new AnnotatedTestClass(), true, true, true),
                Arguments.of(new FinalMemberTestClass(), true, true, true),
                Arguments.of(new NonAnnotatedTestClass(), true, true, false),
                Arguments.of(new InvalidTestClass(), false, true, false),
                Arguments.of(new InvalidMemberTestClass(), false, false, false),
                Arguments.of(new StaticMemberTestClass(), true, true, true)
        );
    }
}
