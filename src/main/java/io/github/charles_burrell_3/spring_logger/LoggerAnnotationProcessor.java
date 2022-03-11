package io.github.charles_burrell_3.spring_logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * Facility for integrating the @Logger annotation into Spring.
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class LoggerAnnotationProcessor implements BeanPostProcessor {
    private final FieldProcessor fieldProcessor = FieldProcessor.get();

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName)
    throws BeansException {
        fieldProcessor.process(bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName)
    throws BeansException {
        return bean;
    }

}
