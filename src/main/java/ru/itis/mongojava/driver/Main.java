package ru.itis.mongojava.driver;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("hiring");
        MongoCollection<Document> collection = database.getCollection("person");
        collection.find().forEach(System.out::println);
        System.out.println();


//        db.person.find( { $or: [ {skills: "java"}, {skills: "react"} ] } );
        Document searchQuery = new Document();
        searchQuery.append("$or", Arrays.asList(
                new Document("skills", "java"),
                new Document("skills", "react")
        ));
        FindIterable<Document> result =  collection.find(searchQuery);
        result.forEach(e -> System.out.println(e.toJson()));
        System.out.println();


        result.projection(new Document("name", 1).
                append("skills", 1).
                append("age", 1)).
                forEach(e -> System.out.println(e.toJson()));
        System.out.println();


//        db.person.find( {email: {$exists: true}, $or: [ {skills: "java"}, {age: {$gt: 24} } ] } );
        Bson searchQuery2 = and(
                                        exists("email"),
                                        or(
                                            new Document("skills", "java"),
                                            gt("age", 24)
                                        )
                                   );
        FindIterable<Document> result2 = collection.find(searchQuery2);
        result2.projection(fields(include("name", "email", "skills", "age"), excludeId()))
                .forEach(System.out::println);
    }
}
