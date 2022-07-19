package com.example.springbootsample.routing;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class MyUserHandler {


    public ServerResponse getUser(ServerRequest request) {
        System.out.println("getUser");

        return ServerResponse.ok().build();
    }

    public ServerResponse getUserCustomers(ServerRequest request) {
        System.out.println("getUserCustomers");

        return ServerResponse.ok().build();
    }

    public ServerResponse deleteUser(ServerRequest request) {
        System.out.println("deleteUser");

        return ServerResponse.ok().build();
    }


}
