# Spring Logger (Java)
## Description
This is a very simple Logging annotation for Java and Java based Spring projects.
## Motivation
I use logging in just about every non-POJO class when I'm developing an application. Setting up a Logger for use
is boilerplate code, and should be made to be as trivial as possible.
## Installation
(TBD)
## Usage
The below shows how to use the `@Logger` annotation on a field. Note the following:
1. Only Log4J and SLF4J are currently supported.
2. If `name` is provided, then that will be the name assigned to the Logger.
3. If `name` is **not** provided, then the canonical class name of the Object being decorated will be used.
```java
package org.companyB.spring_logger;
public class AnnotatedTestClass{
    @Logger(name = "log4J")
    private org.apache.logging.log4j.Logger lo4jLogger;
    @Logger
    private org.slf4j.Logger slf4jLogger;
}
```
### Standalone
If you are not using Spring, then all classes that have fields decorated with the `@Logger` annotation will need to be 
using `io.github.charles_burrell_3.spring_logger.FieldProcessor.get().process(instance).`
### Spring
This should work out of the box with Spring. The `io.github.charles_burrell_3.spring_logger.LoggerAnnotationProcessor` should
handle all the automatic Bean field processing, provided that something like the following is done in a `@Configuration` 
class:
```java
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
```