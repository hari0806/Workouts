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

/**
 * Created by HARI on 6/6/2015.
 */
public class MongoHelper {

    public static void printJson(Document document) {
        JsonWriter jsonWriter = new JsonWriter(new StringWriter(), new JsonWriterSettings(JsonMode.SHELL, true));
        new DocumentCodec().encode(jsonWriter, document, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
        System.out.println(jsonWriter.getWriter());
        System.out.flush();
    }

    public static MongoCollection<Document> fetchCollection(String collectionName){
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(20).build();
        MongoClient client = new MongoClient(new ServerAddress(), options);
        MongoDatabase mongoDatabase = client.getDatabase("test").withReadPreference(ReadPreference.secondary());
        MongoCollection<Document> coll = mongoDatabase.getCollection(collectionName);
        return coll;
    }

    public static MongoCollection<Document> fetchCollection(String database, String collectionName){
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(20).build();
        MongoClient client = new MongoClient(new ServerAddress(), options);
        MongoDatabase mongoDatabase = client.getDatabase(database).withReadPreference(ReadPreference.secondary());
        MongoCollection<Document> coll = mongoDatabase.getCollection(collectionName);
        return coll;
    }
}
