package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoHelper.printJson;
import static com.mongodb.MongoHelper.*;

/**
 * Created by HARI on 6/6/2015.
 */
public class FindTest {
    public static void main(String[] args) {
        MongoCollection<Document> coll = fetchCollection("findTest");
        coll.drop();
        for (int i = 0; i<10; i++){
            Document document = new Document("testName", "testName" + i)
                    .append("index", i);
            coll.insertOne(document);
        }

        System.out.println("Find one:");
        Document document = coll.find().first();
        printJson(document);

        System.out.println("Find all into:");
        List<Document> listDocument = coll.find().into(new ArrayList<Document>());
        for (Document singleDoc : listDocument){
            printJson(singleDoc);
        }

        System.out.println("Find all with iteration:  ");
        MongoCursor<Document> cursor = coll.find().iterator();

        try {
            while (cursor.hasNext()){
                Document cur = cursor.next();
                printJson(cur);
            }
        }finally{
            cursor.close();
        }

        System.out.println("Count:  ");
        long count = coll.count();
        System.out.println(count);
    }


}
