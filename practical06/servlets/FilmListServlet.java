package hei.devweb.practical06.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.practical06.entities.Film;
import hei.devweb.practical06.managers.FilmLibrary;

@WebServlet("/list")
public class FilmListServlet extends AbstractGenericServlet {

	private static final long serialVersionUID = -4105724410207270827L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);

		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Film> filmsList = FilmLibrary.getInstance().listFilms();
		context.setVariable("films", filmsList);
		

		templateEngine.process("list", context, resp.getWriter());
	}

}
