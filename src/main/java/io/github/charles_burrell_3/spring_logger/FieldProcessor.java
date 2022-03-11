package io.github.charles_burrell_3.spring_logger;

import io.vavr.control.Either;
import io.vavr.control.Try;
import io.github.charles_burrell_3.spring_logger.provider.LoggerProvider;
import io.github.charles_burrell_3.spring_logger.provider.LoggerProviderFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * Handles the reflection-based setting of fields annotated with the Logger annotation. This class will make a best
 * effort attempt to bind all annotated fields, and will return a list of failures to the client. This means that
 * the instances' annotated fields may be partially bound, but it is up to  the client to determine what to do in case
 * of failure.
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class FieldProcessor {

    private static FieldProcessor fieldProcessor;

    private FieldProcessor(){}

    public static FieldProcessor get(){
        if(null == fieldProcessor){
            fieldProcessor = new FieldProcessor();
        }
        return fieldProcessor;
    }

    /**
     * Processes the instance, binding any fields decorated with the @Logger annotation to the appropriate values.
     * @param instance Instance to process.
     * @return Either a Boolean success or a String indicating reasons for failure.
     * @since 1.0
     */
    public Either<String, Boolean> process(final Object instance){
        final List<String>errors = new ArrayList<>();
        final List<Field> fields = Arrays.asList(instance.getClass().getDeclaredFields());
        fields.forEach(field -> {
            final Optional<Annotation>annotation = annotatedField(field);
            if(annotation.isPresent()){
                final Try<Boolean>attempt = setValue(field,instance, annotation.get());
                if(attempt.isFailure()) errors.add(attempt.getCause().getMessage());
            }
        });
        return errors.isEmpty() ? Either.right(true) : Either.left(String.join(",", errors));
    }

    private Optional<Annotation> annotatedField(final Field field){
        return Arrays.stream(field.getDeclaredAnnotations())
                .filter(annotation -> annotation instanceof Logger)
                .findFirst();
    }

    private Try<Boolean> setValue(final Field field, final Object instance, final Annotation annotation) {
        return Try.of(()-> {
            final Class<?> _class = field.getType();
            final String loggerName = getLoggerName(_class, annotation);
            final Optional<LoggerProvider<?>> loggerProvider = LoggerProviderFactory.loggerProvider(_class);
            if(loggerProvider.isPresent()){
                return setFieldValue(field, instance, loggerProvider.get().logger(loggerName));
            }
            else{
                final String message = String.format("There is no LoggerProvider implementation for class %s",
                        _class.getCanonicalName());
             throw new IllegalStateException(message);
            }
        });
    }

    private boolean setFieldValue(final Field field, final Object instance, final Object logger)
    throws IllegalAccessException {
        field.setAccessible(true);
        field.set(instance, logger);
        return true;
    }

    private String getLoggerName(final Class<?> _class, final Annotation annotation){
        final String name = ((Logger)annotation).name();
        return name.isEmpty() ? _class.getCanonicalName() : name;
    }
}
