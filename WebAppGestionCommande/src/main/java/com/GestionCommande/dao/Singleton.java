package com.GestionCommande.dao;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.net.UnknownHostException;


public class Singleton{
	 private static Singleton instance = null;
	 
	    private Singleton() throws UnknownHostException,UnsupportedOperationException{

	    }

	    public static synchronized Singleton getInstance()throws UnknownHostException{

	        if (Singleton.instance == null){
	        	Singleton.instance =  new Singleton();
	        }

	         return Singleton.instance;
	    }
	    public  MongoDatabase getConnection() {
	    	String uri ="mongodb://FatihaDB:FATIHA123456789@localhost:27017";
	        MongoClientURI mongoClientURI = new MongoClientURI(uri);
	        MongoClient client = new MongoClient(mongoClientURI);
		MongoDatabase database = client.getDatabase("Mongodb_G_C");
		return database;
	    	
	    }
}
