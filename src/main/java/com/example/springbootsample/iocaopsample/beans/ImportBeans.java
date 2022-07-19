package com.example.springbootsample.iocaopsample.beans;

import lombok.Data;

/**
 * import beans sample
 */
@Data
public class ImportBeans {


    private String desc;

    private String className;

    public ImportBeans() {
        System.out.println("ImportBeans sample ");
    }
}


