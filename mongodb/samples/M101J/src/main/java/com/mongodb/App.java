package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

import java.io.StringWriter;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(20).build();
        MongoClient client = new MongoClient(new ServerAddress(), options);
        MongoDatabase mongoDatabase = client.getDatabase("test").withReadPreference(ReadPreference.secondary());
        MongoCollection<Document> coll = mongoDatabase.getCollection("insetTest");
        coll.drop();
//        insertOneDocument(coll);
        insertManyDocument(coll);
    }

    private static void insertManyDocument(MongoCollection<Document> coll) {
        Document document = new Document()
                .append("name","Hariharan")
                .append("age",30)
                .append("profession","programmer");

        Document document2 = new Document()
                .append("name","Jenitha")
                .append("age",25)
                .append("profession","doctor");

        coll.insertMany(Arrays.asList(document,document2));
    }

    public static void insertOneDocument(MongoCollection<Document> coll){
        Document document = new Document()
                .append("name","Hariharan")
                .append("age",30)
                .append("profession","programmer");

        printJson(document);
        coll.insertOne(document);
        printJson(document);
    }

    public static void printJson(Document document) {
        JsonWriter jsonWriter = new JsonWriter(new StringWriter(), new JsonWriterSettings(JsonMode.SHELL, true));
        new DocumentCodec().encode(jsonWriter, document, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
        System.out.println(jsonWriter.getWriter());
        System.out.flush();
    }
}
