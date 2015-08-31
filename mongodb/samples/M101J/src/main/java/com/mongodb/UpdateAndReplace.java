package com.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoHelper.fetchCollection;
import static com.mongodb.MongoHelper.printJson;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.descending;
import static java.util.Arrays.equals;

/**
 * Created by HARI on 6/7/2015.
 */
public class UpdateAndReplace {

    public static void main(String[] args) {

        MongoCollection<Document> coll = fetchCollection("updateAndReplaceTest");
        coll.drop();

        for (int i=0;i<10;i++){
                coll.insertOne(new Document()
                        .append("_id", i)
                        .append("x", i));
        }

//        coll.replaceOne(eq("x", 5),new Document("y"  ,1000).append("updated","yes"));
//        coll.updateOne(eq("_id",5),new Document("$set",new Document("y",2000).append("updated","no")));
//        coll.updateOne(eq("_id",10), new Document("$set",new Document("y",2000).append("added","yes")),new UpdateOptions().upsert(false));
//        coll.updateMany(gte("x", 5), new Document("$inc", new Document("x", 1)));
//        coll.deleteOne(gte("x", 5));
//        coll.deleteOne(eq("x",5));
        coll.deleteMany(gte("x", 5));
        System.out.println("Updated doc:");
        List<Document> listDocument = coll.find()
                .into(new ArrayList<Document>());
        for (Document singleDoc : listDocument){
            printJson(singleDoc);
        }

        System.out.println("Count:  ");
        long count = coll.count();
        System.out.println(count);
    }
}
