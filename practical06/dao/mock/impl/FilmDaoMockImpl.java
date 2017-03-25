package hei.devweb.practical06.dao.mock.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import hei.devweb.practical06.dao.FilmDao;
import hei.devweb.practical06.entities.Film;
import hei.devweb.practical06.entities.Genre;

public class FilmDaoMockImpl implements FilmDao {
	private TreeMap<Integer, Film> filmsList;

	public FilmDaoMockImpl() {
		filmsList = new TreeMap<Integer, Film>();
		filmsList.put(1, new Film(1, "Captain Fantastic", LocalDate.of(2016, 10, 12), new Genre(1, "Drama"), 118, "Matt Ross",
				"In the forests of the Pacific Northwest, a father devoted to raising his six kids with a rigorous physical and intellectual education is forced to leave his paradise and enter the world, challenging his idea of what it means to be a parent."));
		filmsList.put(2, new Film(2, "Mademoiselle", LocalDate.of(2016, 11, 1), new Genre(1, "Drama"), 144, "Park Chan-Wook",
				"A woman is hired as a handmaiden to a Japanese heiress, but secretly she is involved in a plot to defraud her."));
		filmsList.put(3, new Film(3, "Miss Peregrine's Home for Peculiar Children", LocalDate.of(2016, 10, 5), new Genre(2, "Adventure"), 127, "Tim Burton",
				"When Jacob discovers clues to a mystery that stretches across time, he finds Miss Peregrine's Home for Peculiar Children. But the danger deepens after he gets to know the residents and learns about their special powers."));
		filmsList.put(4, new Film(4, "Ma Vie de Courgette", LocalDate.of(2016, 10, 19), new Genre(1, "Drama"), 66, "Claude Barras",
				"Courgette is an intriguing nickname for a 9-year-old boy. Although his unique story is surprisingly universal."));
		filmsList.put(5, new Film(5, "Doctor Strange", LocalDate.of(2016, 10, 26), new Genre(3, "Action"), 115, "Scott Derrickson",
				"A former neurosurgeon embarks on a journey of healing only to be drawn into the world of the mystic arts."));
	}

	public List<Film> listFilms() {
		return new ArrayList<Film>(filmsList.values());
	}

	public Film getFilm(Integer id) {
		return filmsList.get(id);
	}

	public Film addFilm(Film film) {
		Integer id = filmsList.lastKey() + 1;
		film.setId(id);
		filmsList.put(id, film);
		return film;
	}
}
