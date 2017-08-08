package ru.java.client;


import ru.java.ws.HelloWebService;
//классы, чтобы пропарсить xml-ку с wsdl описанием
//и дотянуться до тега service в нем
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
//эксепшн при работе с объектом URL
import java.net.MalformedURLException;
//нужно, чтобы получить wsdl описаниеи через него
//дотянуться до самого веб-сервиса
import java.net.URL;

public class HelloWebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        //создаем ссылку на wsdl описание
        URL url = new URL("http://localhost:2017/wss/hello?wsdl");

        //параметры следующего  конструктора смотрим в самом первом теге WSDL описания -
        //1-й аргумент смотрим в атрибуте targetNamespace
        //2-й аргумент смотрим в атрибуте name
        QName qname = new QName("http://ws.java.ru/", "HelloWebServiceImplService");

        //теперь мы можем дотянуться до тега service в wsdl описания,
        Service service = Service.create(url, qname);
        //а далее и до вложенного в него тега port, чтобы
        //получить ссылку на удаленный от нас объект веб-сервиса
        HelloWebService hello = service.getPort(HelloWebService.class);

        System.out.println(hello.getHelloString("Java"));
    }

}
