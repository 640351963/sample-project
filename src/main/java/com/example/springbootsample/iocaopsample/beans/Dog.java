package com.example.springbootsample.iocaopsample.beans;

import lombok.Data;

@Data
public class Dog {

    private String name;

    public Dog(){
        System.out.println("spring init ");
    }
}
