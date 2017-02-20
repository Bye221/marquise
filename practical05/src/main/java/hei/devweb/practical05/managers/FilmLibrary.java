package hei.devweb.practical05.managers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import hei.devweb.practical05.entities.Film;
import hei.devweb.practical05.entities.Genre;

public class FilmLibrary {
	
	private static class CinemathequeHolder {
		private final static FilmLibrary instance = new FilmLibrary();
	}
	
	public static FilmLibrary getInstance() {
		return CinemathequeHolder.instance;
	}
	
	private TreeMap<Integer, Film> filmsList;

	private TreeMap<Integer, Genre> genresList;

	

	private FilmLibrary() {
		this.initialize();
	}

	public List<Film> listFilms() {
		return new ArrayList<Film>(filmsList.values());
	}

	public List<Genre> listGenres() {
		return new ArrayList<Genre>(genresList.values());
	}

	public Film getFilm(Integer id) {
		return filmsList.get(id);
	}
	
	public Film getRandomFilm() {
		Random randomGenerator = new Random();
		Integer filmId = randomGenerator.nextInt(filmsList.size())+1;
		return getFilm(filmId);
	}

	public Genre getGenre(Integer id) {
		return genresList.get(id);
	}

	public Film addFilm(Film film) {
		Integer id = filmsList.lastKey() + 1;
		film.setId(id);
		filmsList.put(id, film);
		return film;
	}
	
	public void addGenre(String name) {
		Integer id = genresList.lastKey() + 1;
		Genre newGenre = new Genre(id, name);
		genresList.put(id, newGenre);
	}

	private void initialize() {
		genresList = new TreeMap<Integer, Genre>();
		genresList.put(1, new Genre(1, "Drama"));
		genresList.put(2, new Genre(2, "Adventure"));
		genresList.put(3, new Genre(3, "Action"));
		genresList.put(4, new Genre(4, "Comedy"));
		genresList.put(5, new Genre(5, "Thriller"));

		filmsList = new TreeMap<Integer, Film>();
		filmsList.put(1, new Film(1, "Captain Fantastic", LocalDate.of(2016, 10, 12), genresList.get(1), 118, "Matt Ross",
				"In the forests of the Pacific Northwest, a father devoted to raising his six kids with a rigorous physical and intellectual education is forced to leave his paradise and enter the world, challenging his idea of what it means to be a parent."));
		filmsList.put(2, new Film(2, "Mademoiselle", LocalDate.of(2016, 11, 1), genresList.get(1), 144, "Park Chan-Wook",
				"A woman is hired as a handmaiden to a Japanese heiress, but secretly she is involved in a plot to defraud her."));
		filmsList.put(3, new Film(3, "Miss Peregrine's Home for Peculiar Children", LocalDate.of(2016, 10, 5), genresList.get(2), 127, "Tim Burton",
				"When Jacob discovers clues to a mystery that stretches across time, he finds Miss Peregrine's Home for Peculiar Children. But the danger deepens after he gets to know the residents and learns about their special powers."));
		filmsList.put(4, new Film(4, "Ma Vie de Courgette", LocalDate.of(2016, 10, 19), genresList.get(1), 66, "Claude Barras",
				"Courgette is an intriguing nickname for a 9-year-old boy. Although his unique story is surprisingly universal."));
		filmsList.put(5, new Film(5, "Doctor Strange", LocalDate.of(2016, 10, 26), genresList.get(3), 115, "Scott Derrickson",
				"A former neurosurgeon embarks on a journey of healing only to be drawn into the world of the mystic arts."));
	}
}
