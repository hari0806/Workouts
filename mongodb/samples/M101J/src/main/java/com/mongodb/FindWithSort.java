package com.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoHelper.fetchCollection;
import static com.mongodb.MongoHelper.printJson;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import static java.util.Arrays.asList;

/**
 * Created by HARI on 6/7/2015.
 */
public class FindWithSort {
    public static void main(String[] args) {

            MongoCollection<Document> coll = fetchCollection("findWithSortTest");
            coll.drop();

            for (int i=0;i<10;i++){
                for (int j=0;j<10;j++) {
                    coll.insertOne(new Document()
                            .append("i", i)
                            .append("j", j));
                }
            }

            System.out.println("Find with Sort:");
            Bson projection = fields(include("i","j"),excludeId());

//            Bson sort = new Document("i",1).append("j",1);
//            Bson sort = ascending(asList("i", "j"));
            Bson sort = descending(asList("i", "j"));
            List<Document> listDocument = coll.find()
                                                .projection(projection)
                                                .sort(sort)
                                                .limit(5)
                                                .skip(3)
                                                .into(new ArrayList<Document>());
            for (Document singleDoc : listDocument){
                printJson(singleDoc);
            }

            System.out.println("Count:  ");
            long count = coll.count();
            System.out.println(count);
        }
}
