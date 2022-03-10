package io.github.charles_burrell_3.spring_logger;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class InvalidTestClass implements TestClass {
    @Logger
    private String logger;

    @Override
    public void log() {
        throw new IllegalStateException("Can not log a damn thing!");
    }
}
