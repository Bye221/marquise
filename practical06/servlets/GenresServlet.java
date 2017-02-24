package hei.devweb.practical06.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.practical06.managers.FilmLibrary;

@WebServlet("/genres")
public class GenresServlet extends AbstractGenericServlet {

	private static final long serialVersionUID = -771519263682296043L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);

		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		context.setVariable("genres", FilmLibrary.getInstance().listGenres());

		templateEngine.process("genres", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String genreName = req.getParameter("genreName");
		FilmLibrary.getInstance().addGenre(genreName);
		
		resp.sendRedirect("genres");
	}

	
}
