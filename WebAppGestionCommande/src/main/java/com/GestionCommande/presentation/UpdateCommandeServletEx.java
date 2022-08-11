package com.GestionCommande.presentation;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GestionCommande.dao.CommandeDao;
import com.GestionCommande.entities.Client;
import com.GestionCommande.entities.Commande;
import com.GestionCommande.entities.Produit;
import com.GestionCommande.metier.ICommande;

/**
 * Servlet implementation class UpdateCommandeServletEx
 */
public class UpdateCommandeServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommandeServletEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String ID = request.getParameter("id");
		HttpSession Session = request.getSession(); 
		String C_id = (String) Session.getAttribute("C_id");
		ICommande commandeDao = new CommandeDao();
		Commande commande = new Commande();
		Client client = new Client();
			client.setId(C_id);
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
	    commande.set_id(ID);
	    System.out.print("***************************************************************************************** \n");
	    System.out.println(client.toString());
	    System.out.print("***************************************************************************************** \n");
		System.out.println(commande.toString());  
		System.out.print("***************************************************************************************** \n");
		System.out.println(commande.getProduits().toString());
		System.out.print("***************************************************************************************** \n");
	    commandeDao.Update(commande);
	    response.sendRedirect("CommandeInfoFromServlet");
	}

}
