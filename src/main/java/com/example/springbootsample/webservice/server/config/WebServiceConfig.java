package com.example.springbootsample.webservice.server.config;

import com.example.springbootsample.webservice.server.interfaces.HelloWordImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private HelloWordImpl helloWord;

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        final org.apache.cxf.jaxws.EndpointImpl endpoint = new org.apache.cxf.jaxws.EndpointImpl(springBus(), helloWord);
        endpoint.publish("/helloWord");
        return endpoint;
    }

}
