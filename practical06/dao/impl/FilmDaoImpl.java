package hei.devweb.practical06.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.practical06.dao.FilmDao;
import hei.devweb.practical06.entities.Film;
import hei.devweb.practical06.entities.Genre;

public class FilmDaoImpl implements FilmDao{

	@Override
	public List<Film> listFilms() {
		String query = "SELECT * FROM film JOIN genre ON film.genre_id = genre.genre_id ORDER BY title";
		List<Film> films = new ArrayList<>(); 
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						Genre genre = new Genre(resultSet.getInt("genre_id"), resultSet.getString("name"));
						Film film = new Film(resultSet.getInt("film_id"), resultSet.getString("title"), 
								resultSet.getDate("release_date").toLocalDate(), genre, resultSet.getInt("duration"), 
								resultSet.getString("director"), resultSet.getString("summary"));
						films.add(film);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Film getFilm(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM film JOIN genre ON film.genre_id = genre.genre_id WHERE film_id = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						Genre genre = new Genre(resultSet.getInt("genre_id"), resultSet.getString("name"));
						return  new Film(resultSet.getInt("film_id"), resultSet.getString("title"), 
								resultSet.getDate("release_date").toLocalDate(), genre, resultSet.getInt("duration"), 
								resultSet.getString("director"), resultSet.getString("summary"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Film addFilm(Film film) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO film(title, release_date, genre_id, duration, director, summary) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, film.getTitle());
				statement.setDate(2, Date.valueOf(film.getReleaseDate()));
				statement.setInt(3, film.getGenre().getId());
				statement.setInt(4, film.getDuration());
				statement.setString(5, film.getDirector());
				statement.setString(6, film.getSummary());
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						film.setId(resultSet.getInt(1));
						return film;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
