package com.sai.sri.siddhi.mongodb.client;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongo = new MongoClient( "localhost" , 27017 );


        List<String> dbs = mongo.getDatabaseNames();
        for(String dbStr : dbs){
            System.out.println(dbStr);
        }

        DB db = mongo.getDB("mydb");
        DBCollection table = db.getCollection("firstCollection");

        searchDocument(table);
        insertDocuments(table);
        searchDocument(table);
        updateDocuments(table);
        searchDocument(table);
        deleteDocument(table);
        searchDocument(table);
    }

    private static void insertDocuments(DBCollection table) {
        BasicDBObject document = new BasicDBObject();
        document.put("name", "prasanth");
        document.put("age", 37);
        document.put("createdDate", new Date());
        table.insert(document);

        document = new BasicDBObject();
        document.put("name", "vishnu");
        document.put("age", 29);
        document.put("createdDate", new Date());
        document.put("qualification", "B.E.");
        table.insert(document);

        document = new BasicDBObject();
        document.put("name", "test");
        document.put("age", 21);
        document.put("createdDate", new Date());
        table.insert(document);
    }

    private static void updateDocuments(DBCollection table) {
        BasicDBObject query = new BasicDBObject();
        query.put("name", "vishnu");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "vishnu priya");

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);
    }

    public static void searchDocument(DBCollection table) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "vishnu priya");

        DBCursor cursor = table.find(searchQuery);



        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    private static void deleteDocument(DBCollection table) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "test");

        table.remove(searchQuery);
    }
}
