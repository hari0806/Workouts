package com.mongodb.spark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by HARI on 6/7/2015.
 */
public class FreeMarkerAndSpark {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration(new Version(2,3,22));
        configuration.setClassForTemplateLoading(FreeMarkerStyle.class, "/");
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try{
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    Map<String,Object> displayMap = new HashMap<String, Object>();
                    displayMap.put("displayText","Hello from server");
                    helloTemplate.process(displayMap,writer);
                    System.out.println(writer);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}
