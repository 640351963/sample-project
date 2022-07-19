package com.example.springbootsample.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {


    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        ClassPathResource resource = new ClassPathResource("");
        PropertySource<?> propertySource = loadYml(resource);

        try {
            final List<PropertySource<?>> load = loader.load("customer-rouces", resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertySource<?> loadYml(ClassPathResource resource) {
        return null;
    }

    public static void main(String[] args) {

        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

        try {
            final List<PropertySource<?>> aaa = loader.load("abc", new ClassPathResource("aaa.yml"));
            for (PropertySource<?> propertySource : aaa) {
                System.out.println(propertySource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
