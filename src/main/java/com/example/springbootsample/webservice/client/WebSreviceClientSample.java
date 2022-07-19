package com.example.springbootsample.webservice.client;

import com.google.gson.Gson;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.HashMap;
import java.util.Map;

public class WebSreviceClientSample {

    public static void main(String[] args) {


        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1/services/helloWord?wsdl");

        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            //json的形式
            Map<String,Object> params=new HashMap<String,Object>();
            params.put("name", "dasda");
            Gson gson = new Gson();
            String json = gson.toJson(params);
            objects = client.invoke("sat", json);
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

    }
}
