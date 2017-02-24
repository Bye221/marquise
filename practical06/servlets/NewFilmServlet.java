package hei.devweb.practical06.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import hei.devweb.practical06.entities.Film;
import hei.devweb.practical06.entities.Genre;
import hei.devweb.practical06.managers.FilmLibrary;

@WebServlet("/newfilm")
public class NewFilmServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 4982865059712541281L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);

		WebContext context = new WebContext(req, resp, req.getServletContext());
		List<Genre> genres = FilmLibrary.getInstance().listGenres();
		context.setVariable("genres", genres);
		
		
		templateEngine.process("newfilm", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String director = req.getParameter("director");
		String summary = req.getParameter("summary");
		
		Integer duration = Integer.parseInt(req.getParameter("duration"));
		
		Integer genreId = Integer.parseInt(req.getParameter("genre"));
		Genre genre = FilmLibrary.getInstance().getGenre(genreId);
		
		String releaseDateAsString = req.getParameter("releaseDate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate releaseDate = LocalDate.parse(releaseDateAsString, formatter);
		
		Film newFilm = new Film(null, title, releaseDate, genre, duration, director, summary);
		Film addedFilm = FilmLibrary.getInstance().addFilm(newFilm);
		
		resp.sendRedirect("film?id="+addedFilm.getId());
	}
	
	

	
}
