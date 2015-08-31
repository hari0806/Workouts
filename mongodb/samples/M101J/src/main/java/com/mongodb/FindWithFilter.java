package com.mongodb;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;

import static com.mongodb.client.model.Projections.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mongodb.MongoHelper.fetchCollection;
import static com.mongodb.MongoHelper.printJson;

/**
 * Created by HARI on 6/6/2015.
 */
public class FindWithFilter {

    public static void main(String[] args) {
        MongoCollection<Document> coll = fetchCollection("findWithFilterTest");
        coll.drop();

        for (int i=0;i<10;i++){
            coll.insertOne(new Document()
                    .append("x", new Random().nextInt(2))
                    .append("y", new Random().nextInt(100))
                    .append("i", i));
        }

        System.out.println("Find all into:");
//        Bson bsonFilter = new Document("x",0)
//                .append("y",new Document("$gt",10).append("$lt",50));
        Bson bsonFilter = and(eq("x", 0), gt("y", 0), lt("y", 50));
//        Bson projection = new Document("y",1).append("_id",0);
//        Bson projection = Projections.exclude("x","_id");
//        Bson projection = fields(include("y","i"),exclude("_id"));
        Bson projection = fields(include("y","i"),excludeId());
          List<Document> listDocument = coll.find(bsonFilter).projection(projection).into(new ArrayList<Document>());
        for (Document singleDoc : listDocument){
            printJson(singleDoc);
        }

        System.out.println("Count:  ");
        long count = coll.count(bsonFilter);
        System.out.println(count);
    }
}
