package hei.devweb.practical06.managers;

import java.util.List;

import hei.devweb.practical06.dao.FilmDao;
import hei.devweb.practical06.dao.GenreDao;
import hei.devweb.practical06.dao.impl.FilmDaoImpl;
import hei.devweb.practical06.dao.impl.GenreDaoImpl;
import hei.devweb.practical06.entities.Film;
import hei.devweb.practical06.entities.Genre;

public class FilmLibrary {
	
	private static class FilmLibraryHolder {
		private final static FilmLibrary instance = new FilmLibrary();
	}
	
	public static FilmLibrary getInstance() {
		return FilmLibraryHolder.instance;
	}
	
	private FilmDao filmDao = new FilmDaoImpl();
	private GenreDao genreDao = new GenreDaoImpl();	

	private FilmLibrary() {
	}

	public List<Film> listFilms() {
		return filmDao.listFilms();
	}

	public Film getFilm(Integer id) {
		return filmDao.getFilm(id);
	}

	public Film addFilm(Film film) {
		return filmDao.addFilm(film);
	}

	public List<Genre> listGenres() {
		return genreDao.listGenres();
	}

	public Genre getGenre(Integer id) {
		return genreDao.getGenre(id);
	}

	public Genre addGenre(String nom) {
		return genreDao.addGenre(nom);
	}
}
