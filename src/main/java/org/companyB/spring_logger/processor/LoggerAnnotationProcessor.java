package org.companyB.spring_logger.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * Facility for integrating the @Logger annotation into Spring.
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
@Component
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
