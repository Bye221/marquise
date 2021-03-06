package hei.devweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		String identifiantConnecte = (String) request.getSession().getAttribute("utilisateurConnecte");
		if(identifiantConnecte == null || "".equals(identifiantConnecte)){
		out.println("<h1>Veuillez indiquer votre identifiant :</h1>");
		out.println("<form method=\"post\">");
		out.println("<input type=\"text\" name=\"identifiant\">");
		out.println("<input type=\"submit\" value=\"Se connecter\">");
		out.println("</form>");
		
		
		
	}else{
		out.println(String.format("Bonjour, voici votre identifiant %s", identifiantConnecte));
		out.println("<ul>");
		out.println("<li><a href=\"prive/message1\"</a> premier message prive</li>");
		out.println("<li><a href=\"prive/message2\"</a> deuxieme message prive</li>");
		out.println("</ul>");
		
		
		}
		out.println("</body>");
		out.println("</html>");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("utilisateurConnecte",request.getParameter("identifiant"));
		response.sendRedirect("connexion");
		
	}

}
