package ru.java.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "ru.java.ws.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    @Override
    public String getHelloString(String name) {
        return "Hello, " + name + "!";
    }
}
