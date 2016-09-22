package com.mongodb.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static java.util.Arrays.asList;
import static util.Helpers.printJson;

/**
 * Created by tslepkan on 9/23/16
 */
public class InsertTest {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("course");
        MongoCollection<Document> coll = db.getCollection("insertTest");

        coll.drop();

        Document smith = new Document("name","Smith")
            .append("age", 30)
            .append("profession", "programmer");

        Document jones = new Document("name","Jones")
                .append("age", 25)
                .append("profession", "hacker");

        printJson(smith);
        printJson(jones);

        coll.insertMany(asList(smith,jones));

        printJson(smith);
        printJson(jones);

    }
}
