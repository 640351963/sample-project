package com.example.springbootsample.webservice.server.interfaces;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;


import javax.jws.WebService;
import java.io.IOException;
import java.io.StringWriter;

@Component
@WebService(targetNamespace="http://xcb.targetname.com",
        endpointInterface ="com.example.springbootsample.webservice.server.interfaces.IHelloWord")
public class HelloWordImpl implements IHelloWord{
    String str = "hello word";
    @Override
    public String sat(String helloword) {
        System.out.println("进入接口...");
        return createXML(3,helloword);
    }

    public static void main(String[] args) {

        final HelloWordImpl helloWord = new HelloWordImpl();
        final String xml = helloWord.createXML(3,"详细描述");
        System.out.println(xml);
    }

    public String createXML(int i,String desc){
        String strXML = null;
        Document document = DocumentHelper.createDocument();
        // 创建根节点并添加进文档
        Element root = document.addElement("persons");
        for(int j=0;j<i;j++){
            Element person = root.addElement("person");
            person.addAttribute("id", "100"+i).addAttribute("location", "中原"+i+"区");
            Element name = person.addElement("name");
            name.setText("小明"+i);
            Element age = person.addElement("age");
            age.addText("1"+i); //值！！
            if(!"".equals(desc)){
                final Element desc2 = person.addElement("desc");
                desc2.setText(desc+i);
            }
        }
        //--------
        StringWriter strWtr = new StringWriter();
        OutputFormat format = OutputFormat.createPrettyPrint();//Format格式！！
        format.setEncoding("UTF-8");
        XMLWriter xmlWriter =new XMLWriter(strWtr, format);
        try {
            xmlWriter.write(document);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        strXML = strWtr.toString();
        return strXML;
    }
}
