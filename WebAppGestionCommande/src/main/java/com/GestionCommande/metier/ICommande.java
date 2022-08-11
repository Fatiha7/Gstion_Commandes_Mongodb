package com.GestionCommande.metier;

import java.net.UnknownHostException;
import java.util.Collection;

import com.GestionCommande.entities.Client;
import com.GestionCommande.entities.Commande;
import com.GestionCommande.entities.Produit;

public interface ICommande {

	public Collection<Commande> findAll() throws UnknownHostException;
	public  void insert(Commande commandee) throws UnknownHostException;
	public Collection<Produit> ListProduits() throws UnknownHostException;
	public Collection<Client> ListClient()  throws UnknownHostException;
	public Commande findOne(String id) throws UnknownHostException;
	public void Delete(String id) throws UnknownHostException;
	public void Update(Commande commande) throws UnknownHostException;
	
}
