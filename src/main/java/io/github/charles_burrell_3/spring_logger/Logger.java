package io.github.charles_burrell_3.spring_logger;

import java.lang.annotation.*;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 * This annotation is to be used on a field that represents a logging resource.
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Logger {
    String name() default "";
}
