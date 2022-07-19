package com.example.springbootsample.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 内置应用参数使用
 */
@Component
public class CustomerSampleBanner {


//
//    @Value("${application.version}")
//    private String version;
//
//
//
//    @Value("${application.version}")
//    private String formattedVersion;
//
//
//    @Value("${application.formatted-version}")
//    private String formatted2;
//
//
//    @Value("${spring-boot.version}")
//    private String bootVersion;
//
//    @PostConstruct
//    public void  show(){
//        System.out.println("version->");
//        System.out.println(version);
//
//        System.out.println("application.formatted-version->");
//        System.out.println(formatted2);
//
//        System.out.println("spring-boot.version->");
//        System.out.println(bootVersion);
//
//        System.out.println("version->");
//        System.out.println(version);
//    }

}
