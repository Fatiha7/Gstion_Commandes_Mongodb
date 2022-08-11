package com.GestionCommande.dao;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.GestionCommande.entities.Client;
import com.GestionCommande.entities.Commande;
import com.GestionCommande.entities.Produit;
import com.GestionCommande.metier.ICommande;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


public class CommandeDao implements Printable, ICommande {

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
		
	}
	//--------------------------Commande Insert --------------------------------
	public  void insert(Commande commande) throws UnknownHostException {
	
	Singleton MyConnection=Singleton.getInstance();
	MongoCollection<Document> collection= MyConnection.getConnection().getCollection("Commandes");
	MongoCollection<Document> collectionC= MyConnection.getConnection().getCollection("Clients");
	Document Client = new Document("C_id",commande.getClient().getId()).append("nom", commande.getClient().getNom()).append("prenom", commande.getClient().getPrenom()).append("adress",commande.getClient().getAdresse()).append("Phone",commande.getClient().getPhone());
	Document Commande= new Document("Pnom",commande.getProduits().getPnom() ).append("ID", commande.get_id()).append("C_id", commande.getClient().getId()).append("date",commande.getDate()).append("quantite",commande.getQuantite()).append("prixT", commande.getPrixT());
	collection.insertOne(Commande);
	collectionC.insertOne(Client);
	}
	
	
	//--------------------------Find All --------------------------------
	
	public Collection<Commande> findAll() throws UnknownHostException {
		Singleton MyConnection=Singleton.getInstance();
		MongoCollection<Document> collection= MyConnection.getConnection().getCollection("Commandes");
		Collection<Commande> com=new  ArrayList<Commande>();
		FindIterable<Document> alldocs = collection.find();
		ICommande service = new CommandeDao();
		System.out.println(alldocs);
		alldocs.forEach((Document document) -> {
			Commande commandee=new Commande();
			commandee.set_id(document.getString("ID"));
			commandee.setDate(document.getString("date"));
			commandee.setPrixT(document.get("prixT"));
			try {
				for(Client client:service.ListClient()) {
					if(client.getId().equals(document.getString("C_id"))) {
						commandee.setClient(client);
					}
				}
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			try {
				for(Produit produit:service.ListProduits()) {
					
					if(produit.getPnom().equals(document.getString("Pnom"))) {
						commandee.setProduits(produit);
					}
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			com.add(commandee);
			
			});
		return com;}


	//--------------------------Produit List --------------------------------
	public Collection<Produit> ListProduits() throws UnknownHostException {
		Singleton MyConnection=Singleton.getInstance();
		MongoCollection<Document> collectionP= MyConnection.getConnection().getCollection("Produits");
		Collection<Produit> produitL=new  ArrayList<Produit>();
		FindIterable<Document> DoProduit =collectionP.find();
		DoProduit.forEach((Document docP)->{
		Produit produit = new Produit();
		produit.setPnom(docP.getString("Pnom"));
		produit.setStock(docP.getString("Stock"));
		produit.setPrix(docP.getString("prix"));
		 produitL.add(produit);
		});

		return produitL;
	}


	//--------------------------Client List --------------------------------
	public Collection<Client> ListClient() throws UnknownHostException {
		Singleton MyConnection=Singleton.getInstance();
		MongoCollection<Document> collectionC= MyConnection.getConnection().getCollection("Clients");
		Collection<Client> clientL=new  ArrayList<Client>();
		FindIterable<Document> Doclient =collectionC.find();
		Doclient.forEach((Document docC)->{
		Client client = new Client();
		client.setId(docC.getString("C_id"));
		client.setNom(docC.getString("nom"));
		client.setPrenom(docC.getString("prenom"));
		client.setAdresse(docC.getString("adress"));
		client.setPhone(docC.getString("Phone"));
		 clientL.add(client);
		});
		return clientL;
	}
	@Override



	//--------------------------Find One by ID --------------------------------
	public Commande findOne(String id) throws UnknownHostException {
		Singleton MyConnection=Singleton.getInstance();
		MongoCollection<Document> collection= MyConnection.getConnection().getCollection("Commandes");
		FindIterable<Document> document = collection.find(new Document("ID",id));
		ICommande service = new CommandeDao();
		Commande commande=new Commande();
		document.forEach((Document doc)->{
			commande.set_id(id);
			commande.setDate(doc.getString("date"));
			commande.setQuantite(doc.get("quantite"));
			commande.setPrixT(doc.get("prixT"));
			try {
				for(Client client:service.ListClient()) {
					if(client.getId().equals(doc.getString("C_id"))) {
						commande.setClient(client);
					}
				}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				for(Produit produit:service.ListProduits()) {
					
					if(produit.getPnom().equals(doc.getString("Pnom"))) {
						commande.setProduits(produit);
					}
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			});
			
			
		
		
		return commande;
	}
	//--------------------------Delete One by ID --------------------------------
	public void Delete(String id) throws UnknownHostException {
		Singleton MyConnection=Singleton.getInstance();
		MongoCollection<Document> collection= MyConnection.getConnection().getCollection("Commandes");
		collection.deleteOne(Filters.eq("ID", id));
		
		
	}
	//--------------------------Update One by ID  --------------------------------
	public void Update(Commande commande) throws UnknownHostException {
		Singleton MyConnection=Singleton.getInstance();
		MongoCollection<Document> collection= MyConnection.getConnection().getCollection("Commandes");
		MongoCollection<Document> collectionC= MyConnection.getConnection().getCollection("Clients");
		collectionC.updateOne(Filters.eq("C_id",commande.getClient().getId()),Updates.set("nom", commande.getClient().getNom()));
		collectionC.updateOne(Filters.eq("C_id",commande.getClient().getId()),Updates.set("prenom", commande.getClient().getPrenom()));
		collectionC.updateOne(Filters.eq("C_id",commande.getClient().getId()),Updates.set("adress",commande.getClient().getAdresse()));
		collectionC.updateOne(Filters.eq("C_id",commande.getClient().getId()),Updates.set("Phone", commande.getClient().getAdresse()));
		collection.updateOne(Filters.eq("ID",commande.get_id()), Updates.set("Pnom",commande.getProduits().getPnom()));
		collection.updateOne(Filters.eq("ID",commande.get_id()), Updates.set("quantite",commande.getQuantite()));
		collection.updateOne(Filters.eq("ID",commande.get_id()), Updates.set("prixT", commande.getPrixT()));
		collection.updateOne(Filters.eq("ID",commande.get_id()), Updates.set("date",commande.getDate()));
	
	}
	}