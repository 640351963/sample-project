package com.example.springbootsample.webservice.server.interfaces;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://xcb.targetname.com")
public interface IHelloWord {

    public String sat(@WebParam(name = "hello") String helloword);

}
