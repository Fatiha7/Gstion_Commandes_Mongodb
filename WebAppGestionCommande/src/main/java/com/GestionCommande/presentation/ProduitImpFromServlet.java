package com.GestionCommande.presentation;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GestionCommande.entities.Produit;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

/**
 * Servlet implementation class ProduitImpFromServlet
 */
public class ProduitImpFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitImpFromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession Session = request.getSession(); 
		Collection<Produit> produits=(Collection<Produit>) Session.getAttribute("produits");
		String Path = request.getServletContext().getRealPath("/WEB-INF/ProduitsList.pdf");
		response.setContentType("application/pdf");
		
			try(PdfReader reader = new PdfReader(Path);
			PdfWriter writer= new PdfWriter(response.getOutputStream());
			PdfDocument document = new PdfDocument(reader,writer);){
			
			PdfPage page = document.getPage(1);
			PdfCanvas canvas = new PdfCanvas(page);
			FontProgram fontProgram = FontProgramFactory.createFont();
			PdfFont font =  PdfFontFactory.createFont(fontProgram, "utf-8");
			canvas.setFontAndSize( font, 10 );
			canvas.beginText();
            int top = 550;
                       
            for (Produit produit : produits) {
               canvas.setTextMatrix( 120,top);
             canvas.showText(produit.getPnom());
            // canvas.showText( "" + produit.getPnom() );
             canvas.setTextMatrix( 290,top);
             canvas.showText(produit.getPrix());
             canvas.setTextMatrix( 430,top);
             canvas.showText(produit.getStock());
             top -= 20;
            }
            
			   canvas.endText();
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
