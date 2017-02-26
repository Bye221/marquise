package hei.devweb.practical06.dao;

import java.util.List;

import hei.devweb.practical06.entities.Film;

public interface FilmDao {
	public List<Film> listFilms();

	public Film getFilm(Integer id);

	public Film addFilm(Film film);
}
