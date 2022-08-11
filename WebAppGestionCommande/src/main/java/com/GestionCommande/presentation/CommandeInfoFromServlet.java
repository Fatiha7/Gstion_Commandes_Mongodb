package com.GestionCommande.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GestionCommande.dao.CommandeDao;
import com.GestionCommande.entities.Commande;
import com.GestionCommande.metier.ICommande;


/**
 * Servlet implementation class CommandeInfoFromServlet
 */
@WebServlet("/CommandeInfoFromServlet")
public class CommandeInfoFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeInfoFromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICommande service= new CommandeDao();
		System.out.print("-----------------------servlet-------------------------------");
		Collection<Commande> commandes = service.findAll();
		request.setAttribute("commandes", commandes);
		
		RequestDispatcher rd = request.getRequestDispatcher("CommandesList.jsp");
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
