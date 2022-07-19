package com.example.springbootsample.iocaopsample.context;

import com.example.springbootsample.iocaopsample.beans.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.print.Doc;

/**
 *
 */
public class ContextSample {

    public static void main(String[] args) {

        final ContextSample c = new ContextSample();
        testFileSystemApplication();
    }

    public static void  testFileSystemApplication(){
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\code-write\\spring-boot-sample\\src\\main\\java\\com\\example\\springbootsample\\iocaopsample\\configs\\beans1.xml");


        final Dog bean = context.getBean(Dog.class);
        System.out.println(bean);
    }
}

