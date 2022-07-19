package com.example.springbootsample.iocaopsample.factory;

public class DefaultServiceLocator2 {


    private static ClientService clientService = new ClientServiceImpl();

    private static AccountService accountService =  new AccountServiceImpl();

    public ClientService clientService(){
        return  clientService;
    }

    public AccountService accountService(){
        return accountService;
    }
}
