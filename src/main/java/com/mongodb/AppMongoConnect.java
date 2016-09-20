package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by tslepkan on 9/20/16
 */
public class AppMongoConnect {
    public static void main(String[] args) {
        MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(100).build();
//        MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoClient client = new MongoClient(new ServerAddress(), options);

        MongoDatabase db = client.getDatabase("test").withReadPreference(ReadPreference.secondary());

        MongoCollection<Document> coll = db.getCollection("test");
    }
}
