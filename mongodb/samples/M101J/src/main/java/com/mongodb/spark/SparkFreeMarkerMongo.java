package com.mongodb.spark;

import com.mongodb.client.MongoCollection;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.bson.Document;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;

import static com.mongodb.MongoHelper.*;
import static spark.Spark.get;

/**
 * Created by HARI on 6/7/2015.
 */
public class SparkFreeMarkerMongo {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration(new Version(2,3,22));
        configuration.setClassForTemplateLoading(FreeMarkerStyle.class, "/");

        final MongoCollection<Document> coll = fetchCollection("hello");
        coll.drop();
        coll.insertOne(new Document("displayText", "Hello Spark with freemarker and mongo"));

        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try{
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    Document document = coll.find().first();
                    helloTemplate.process(document,writer);
                    System.out.println(writer);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}
