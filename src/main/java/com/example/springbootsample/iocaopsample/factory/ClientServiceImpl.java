package com.example.springbootsample.iocaopsample.factory;

/**
 * say hello
 *
 * @author Xie Bin
 * @date 2022-07-11
 */
public class ClientServiceImpl implements ClientService {
    @Override
    public String sayHello() {
        return "hello word";
    }
}
