package com.Pro150.Casino;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.*;

public class BllCasino {
   //

    @Autowired
    private AccountRepository repo;



        public void add(Account account){
        repo.save(account);
        }

    }
