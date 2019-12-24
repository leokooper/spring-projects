package ru.leonchenko.spring.springlibrary;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = ("ru.leonchenko.spring.springlibrary"))
public class ServletInitializer extends SpringBootServletInitializer {

}

