package hei.devweb.practical06.dao;

import java.util.List;

import hei.devweb.practical06.entities.Genre;

public interface GenreDao {
	public List<Genre> listGenres();

	public Genre getGenre(Integer id);

	public Genre addGenre(String nom);
}
