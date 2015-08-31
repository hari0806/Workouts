package com.mongodb.spark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HARI on 6/7/2015.
 */
public class FreeMarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration(new Version(2,3,22));
        configuration.setClassForTemplateLoading(FreeMarkerStyle.class, "/");
        try{
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String,Object> displayMap = new HashMap<String, Object>();
            displayMap.put("displayText","Hello from server");
            helloTemplate.process(displayMap,writer);
            System.out.println(writer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
