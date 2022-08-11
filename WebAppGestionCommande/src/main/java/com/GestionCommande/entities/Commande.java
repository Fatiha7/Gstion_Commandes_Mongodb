package com.GestionCommande.entities;

public class Commande {
	
	private String _id;
	private Produit produits;
	private Client Client;
	private String date;
	private Object quantite;
	private Object prixT;
	public Commande(String _id, Produit produits, Client client, String date, Object quantite,
			float prixT) {
		super();
		this._id = _id;
		this.produits = produits;
		Client = client;
		this.date = date;
		this.quantite = quantite;
		this.prixT = prixT;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String id) {
		this._id = id;
	}
	public Produit getProduits() {
		return produits;
	}
	public void setProduits(Produit produits) {
		this.produits = produits;
	}
	public Client getClient() {
		return Client;
	}
	public void setClient(Client client) {
		Client = client;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Object getQuantite() {
		return quantite;
	}
	public void setQuantite(Object quantite) {
		this.quantite = quantite;
	}
	public Object getPrixT() {
		return prixT;
	}
	public void setPrixT(Object prixT) {
		this.prixT = prixT;
	}
	
	@Override
	public String toString() {
		return "Commande [_id=" + _id + ", produits=" + produits + ", Client=" + Client + ", date=" + date
				+ ", quantite=" + quantite + ", prixT=" + prixT + "]";
	}
	
	
}
