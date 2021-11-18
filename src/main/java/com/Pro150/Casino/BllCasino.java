package com.Pro150.Casino;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.*;

public class BllCasino {
   //
   private final MongoCollection<Document> userCollection;

    public BllCasino() {
        var client = MongoClients.create("mongodb+srv://group:pro150@userinformation.xrasy.mongodb.net/UserInformation?retryWrites=true&w=majority");
        var database = client.getDatabase("UserInformation");
        userCollection = database.getCollection("Users");

        }
    }
