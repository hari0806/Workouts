package com.mongodb;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by HARI on 6/6/2015.
 */
public class DocumentTest {
    public static void main(String[] args) {
        Document document = new Document()
                .append("str","MongoDB string")
                .append("intValue", 42)
                .append("longValue", 1L)
                .append("double",1.1)
                .append("b", false)
                .append("date", new Date())
                .append("anotherdoc",new Document("nestedString","nestedStringValue"))
                .append("list", Arrays.asList(1,2,3));
        BsonDocument bsonDocument = new BsonDocument()
                .append("str",new BsonString("MongoDB string"));
        System.out.println(bsonDocument.getString("str"));
        printJson(document);
    }

    public static void printJson(Document document) {
        JsonWriter jsonWriter = new JsonWriter(new StringWriter(), new JsonWriterSettings(JsonMode.SHELL, true));
        new DocumentCodec().encode(jsonWriter, document, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
        System.out.println(jsonWriter.getWriter());
        System.out.flush();
    }
}
