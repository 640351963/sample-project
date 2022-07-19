package com.example.springbootsample.iocaopsample.factory;

public class DefaultServiceLocator {

    private static ClientService clientService = new ClientServiceImpl();

    public  ClientService createClientServiceInstance(){
        return clientService;
    }
}
