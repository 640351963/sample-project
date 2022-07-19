package com.example.springbootsample.core.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner
 */
@Component
public class CommandLineRunnerSample implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("command runner - >");
    }
}
