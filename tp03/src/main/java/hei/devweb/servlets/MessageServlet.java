package hei.devweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String message = "Mon message à configurer";
	
	

  

	@Override
	public void init(ServletConfig config) throws ServletException {
		String messageConfig = config.getInitParameter("message");
		if(messageConfig != null && "".equals(messageConfig)){
			message = messageConfig;
		}
		
	}

	public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>Message prive</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>votre message privé</h1>");
		out.println(String.format("<p>%s</p>", message));
		
		
		out.println("</body>");
		out.println("</html>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
