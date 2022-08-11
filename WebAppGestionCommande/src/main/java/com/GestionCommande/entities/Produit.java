package com.GestionCommande.entities;

public class Produit {
	private String _id;
	private String Pnom;
	private String Stock;
	private String prix;
	public Produit(String _id, String pnom, String stock, String prix) {
		super();
		this._id = _id;
		Pnom = pnom;
		Stock = stock;
		this.prix = prix;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getPnom() {
		return Pnom;
	}
	public void setPnom(String pnom) {
		Pnom = pnom;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Produit [_id=" + _id + ", Pnom=" + Pnom + ", Stock=" + Stock + ", prix=" + prix + "]";
	}
	
}
