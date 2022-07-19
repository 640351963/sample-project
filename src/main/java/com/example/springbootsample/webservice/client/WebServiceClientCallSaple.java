package com.example.springbootsample.webservice.client;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
public class WebServiceClientCallSaple {

    /**

     If Spring MVC is present, an AnnotationConfigServletWebServerApplicationContext is used
     If Spring MVC is not present and Spring WebFlux is present, an AnnotationConfigReactiveWebServerApplicationContext is used
     Otherwise, AnnotationConfigApplicationContext is used

     */
    public static void main(String[] args) {

        String endpoint = "http://127.0.0.1/services/helloWord?wsdl";
        Service service = new Service();
        try{
            final javax.xml.rpc.Call call = service.createCall();
            call.setTargetEndpointAddress(endpoint);
            call.setOperationName(new QName("http://xcb.targetname.com", //wsdl文件中的targetNamespace
                    "sat") //接口实现功能的方法
            );
            call.addParameter("hello",XMLType.XSD_STRING,ParameterMode.IN);// 接口的参数
            call.setReturnType(XMLType.XSD_STRING);// 设置返回类型
            String nodeInexCode = "xxx";
            String result = (String) call.invoke(new Object[]{nodeInexCode});

            System.out.println(result);

//            call.setOperationName(new );

        }catch (Exception e){
e.printStackTrace();
        }
//        Service
    }



}
