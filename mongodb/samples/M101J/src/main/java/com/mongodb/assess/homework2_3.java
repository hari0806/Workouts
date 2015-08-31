package com.mongodb.assess;

import com.mongodb.MongoHelper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoHelper.printJson;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.asList;

/**
 * Created by HARI on 6/7/2015.
 */
public class homework2_3 {
    public static void main(String[] args) {

        MongoCollection<Document> coll = MongoHelper.fetchCollection("students", "grades");
        System.out.println("Find with Sort:");
        Bson projection = fields(include("student_id","score"));

//            Bson sort = new Document("i",1).append("j",1);
//            Bson sort = ascending(asList("i", "j"));
        Bson sort = ascending(asList("student_id", "score"));
        List<Document> listDocument = coll.find(eq("type","homework"))
                .projection(projection)
                .sort(sort)
                .into(new ArrayList<Document>());
        double student_id = -1l;
        for (Document singleDoc : listDocument){
            double student_id_temp = singleDoc.getDouble("student_id");
            if(student_id_temp != student_id){
                printJson(singleDoc);
                coll.deleteOne(singleDoc);
                student_id = student_id_temp;
            }
        }

        System.out.println("Count:  ");
        long count = coll.count();
        System.out.println(count);
    }
}
