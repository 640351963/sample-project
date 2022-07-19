package com.example.springbootsample.core.args;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArgumentsBean {

    public ApplicationArguments applicationArguments;

    public ArgumentsBean(ApplicationArguments applicationArguments){
        this.applicationArguments = applicationArguments;

        boolean debug = applicationArguments.containsOption("debug");
        List<String> files = applicationArguments.getNonOptionArgs();

        System.out.println("files->");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(files);

    }





}

