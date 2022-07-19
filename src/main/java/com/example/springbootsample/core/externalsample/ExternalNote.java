package com.example.springbootsample.core.externalsample;

/**
 Externalized Configuration
 Spring Boot lets you externalize your configuration so that you can work with the same application code in different environments. You can use a variety of external configuration sources, include Java properties files, YAML files, environment variables, and command-line arguments.
 Property values can be injected directly into your beans by using the @Value annotation, accessed through Spring’s Environment abstraction, or be bound to structured objects through @ConfigurationProperties.
 Spring Boot uses a very particular PropertySource order that is designed to allow sensible overriding of values. Properties are considered in the following order (with values from lower items overriding earlier ones):
 Default properties (specified by setting SpringApplication.setDefaultProperties).
 @PropertySource annotations on your @Configuration classes. Please note that such property sources are not added to the Environment until the application context is being refreshed. This is too late to configure certain properties such as logging.* and spring.main.* which are read before refresh begins.
 Config data (such as application.properties files).
 A RandomValuePropertySource that has properties only in random.*.
 OS environment variables.
 Java System properties (System.getProperties()).
 JNDI attributes from java:comp/env.
 ServletContext init parameters.
 ServletConfig init parameters.
 Properties from SPRING_APPLICATION_JSON (inline JSON embedded in an environment variable or system property).
 Command line arguments.
 properties attribute on your tests. Available on @SpringBootTest and the test annotations for testing a particular slice of your application.
 @TestPropertySource annotations on your tests.
 Devtools global settings properties in the $HOME/.config/spring-boot directory when devtools is active.
 Config data files are considered in the following order:
 Application properties packaged inside your jar (application.properties and YAML variants).
 Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants).
 Application properties outside of your packaged jar (application.properties and YAML variants).
 Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants).
 */

public class ExternalNote {
}
