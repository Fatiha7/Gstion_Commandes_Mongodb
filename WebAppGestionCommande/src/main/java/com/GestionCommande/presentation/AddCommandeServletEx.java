package com.GestionCommande.presentation;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GestionCommande.dao.CommandeDao;
import com.GestionCommande.entities.Client;
import com.GestionCommande.entities.Commande;
import com.GestionCommande.entities.Produit;
import com.GestionCommande.metier.ICommande;

/**
 * Servlet implementation class AddCommandeServletEx
 */
public class AddCommandeServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommandeServletEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Pnom = request.getParameter("Pnom");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		String Phone = request.getParameter("Phone");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		ICommande commandeDao = new CommandeDao();
		Commande commande = new Commande();
		Client client = new Client();
		Collection<Client>  clients= new CommandeDao().ListClient();
		int i=0;
		for(Client clientt: clients) {
				i+=Integer.parseInt(clientt.getId());
		}
			client.setId(String.valueOf(i));
			client.setAdresse(adresse);
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setPhone(Phone);
			commande.setClient(client);
		
		Collection<Produit>  produits= new CommandeDao().ListProduits();
		for(Produit produit: produits) {
			if(produit.getPnom().equals(Pnom)) {
				commande.setProduits(produit);
			}
		}
		
		
		commande.setPrixT(Integer.parseInt(commande.getProduits().getPrix())*quantite);
	    long millis = System.currentTimeMillis();  
	      
	    // creating a new object of the class Date  
	    java.util.Date date = new java.util.Date(millis);      
	    commande.setQuantite(quantite);
	    commande.setDate(date.toString());
	 // what is our range?
	    int max = 2000;
	    int min = 1;
	    // create instance of Random class
	    Random randomNum = new Random();
	    
	    int showMe = min + randomNum.nextInt(max);
	    commande.set_id("com"+client.getId()+String.valueOf(showMe));
	    System.out.print("***************************************************************************************** \n");
	    System.out.println(client.toString());
	    System.out.print("***************************************************************************************** \n");
		System.out.println(commande.toString());  
		System.out.print("***************************************************************************************** \n");
		System.out.println(commande.getProduits().toString());
		System.out.print("***************************************************************************************** \n");
		   
	    commandeDao.insert(commande);
	    response.sendRedirect("CommandeInfoFromServlet");
	   
	}

}
