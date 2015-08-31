package com.mongodb.assess;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoHelper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.mongodb.MongoHelper.*;
import static com.mongodb.MongoHelper.printJson;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;

/**
 * Created by HARI on 6/9/2015.
 */
public class homework3_1 {
    public static void main(String[] args) {

        MongoCollection<Document> coll = fetchCollection("school", "students");
        List<Document> listDocument = coll.find()
                .into(new ArrayList<Document>());
        for (Document singleDoc : listDocument){
            List<Document> scores = (ArrayList)singleDoc.get("scores");
            TreeMap<Double, Document> map = new TreeMap<Double, Document>();
            for (Document score: scores){
                String type = score.getString("type");
                Double doubleScore = score.getDouble("score");
                if(type.equals("homework")){
                    map.put(doubleScore,score);
                    System.out.println("type: "+ score.getString("type") + "Score: " + score.getDouble("score"));
                }
            }
            Document hwDoc = map.firstEntry().getValue();
            scores.remove(hwDoc);
            Document updatedDoc = new Document(singleDoc);
            updatedDoc.put("scores", scores);
            System.out.println("-------type: "+ hwDoc.getString("type") + "Score: " + hwDoc.getDouble("score") + " " + singleDoc.get("_id"));
//            for (Document score:scores){
//                System.out.println("-------type: "+ score.getString("type") + "Score: " + score.getDouble("score"));
//            }
            Document filter = new Document().append("_id", singleDoc.get("_id"));
            coll.replaceOne(filter ,updatedDoc);
            printJson(singleDoc);

//            if(student_id_temp != student_id){
//                printJson(singleDoc);
//                coll.deleteOne(singleDoc);
//                student_id = student_id_temp;
//            }
        }

        System.out.println("Count:  ");
        long count = coll.count();
        System.out.println(count);
    }
}
