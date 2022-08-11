package com.GestionCommande.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GestionCommande.entities.Client;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

/**
 * Servlet implementation class ClientImpFromServlet
 */
public class ClientImpFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientImpFromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession Session = request.getSession(); 
		Collection<Client> clients=(Collection<Client>) Session.getAttribute("clients");
		String Path = request.getServletContext().getRealPath("/WEB-INF/ClientsList.pdf");
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
                       
            for (Client client : clients) {
               canvas.setTextMatrix( 90,top);
             canvas.showText(client.getId());
            // canvas.showText( "" + produit.getPnom() );
             canvas.setTextMatrix( 140,top);
             canvas.showText(client.getNom());
             canvas.setTextMatrix(215 ,top);
             canvas.showText(client.getPrenom());
             canvas.setTextMatrix( 320,top);
             canvas.showText(client.getAdresse());
             canvas.setTextMatrix( 420,top);
             canvas.showText(client.getPhone());
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
