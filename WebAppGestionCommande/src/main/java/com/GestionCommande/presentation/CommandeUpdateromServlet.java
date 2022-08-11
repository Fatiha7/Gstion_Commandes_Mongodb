package com.GestionCommande.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GestionCommande.dao.CommandeDao;
import com.GestionCommande.entities.Commande;
import com.GestionCommande.entities.Produit;

/**
 * Servlet implementation class CommandeUpdateromServlet
 */
public class CommandeUpdateromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeUpdateromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id").toString();
		Commande commande = new CommandeDao().findOne(id);
		request.setAttribute("commande", commande);
		Collection<Produit>  produits= new CommandeDao().ListProduits();
		request.setAttribute("produitsA", produits);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateCommande.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
