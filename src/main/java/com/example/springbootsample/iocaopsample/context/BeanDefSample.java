package com.example.springbootsample.iocaopsample.context;

import com.example.springbootsample.iocaopsample.beans.Dog;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 bean definition tab:

 Class InstanceBeans
 Name naming Beans
 Scope Bean Scopes
 Constructor arguments
 Properties
 Autowireing mode
 Lazy initialization mode
 Initialization method
 descory method
 */
public class BeanDefSample {

    public static void main(String[] args) {
        getBeanFactory();

    }

    public static void getBeanFactory(){
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\code-write\\spring-boot-sample\\src\\main\\java\\com\\example\\springbootsample\\iocaopsample\\configs\\beans1.xml");
        System.out.println(context);
        // DefaultListableBeanFactory  ->  registerSingleton  registerBeanDefinition
        final Dog bean = context.getBean(Dog.class);
        final BeanFactory parentBeanFactory = context.getParentBeanFactory();
        System.out.println("parentBeanFactory->");
        System.out.println(parentBeanFactory);

    }
}
