package ru.java.endpoint;


import ru.java.ws.HelloWebServiceImpl;

import javax.xml.ws.Endpoint;

public class HelloWebServicePublisher {

    public static void main(String[] args) {
        //запускаем веб-сервис на порту 2017
        //и по адресу, указанному в первом аргументе
        //запускаем веб-сервис, передаваемый во втором аргументе
        Endpoint.publish("http://localhost:2017/wss/hello", new HelloWebServiceImpl());
    }

}
