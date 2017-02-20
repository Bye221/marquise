package hei.devweb.practical05.servlets;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.practical05.entities.Film;
import hei.devweb.practical05.managers.FilmLibrary;

@WebServlet("/film")
public class DetailFilmServlet extends AbstractGenericServlet {

	private static final long serialVersionUID = 4127160026348238231L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);

		WebContext context = new WebContext(req, resp, req.getServletContext());
				
		Integer filmId = Integer.parseInt(req.getParameter("id"));
		Film film = FilmLibrary.getInstance().getFilm(filmId);
		context.setVariable("film", film);
		
		templateEngine.process("film", context, resp.getWriter());
	}

	
}
