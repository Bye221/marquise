package hei.devweb.practical06.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import hei.devweb.practical06.entities.Film;
import hei.devweb.practical06.managers.FilmLibrary;

@WebFilter("/*")
public class RandomFilmFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Film randomFilm = FilmLibrary.getInstance().getFilm(1);
		request.setAttribute("randomFilm", randomFilm);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
	}

}
