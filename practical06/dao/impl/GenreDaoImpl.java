package hei.devweb.practical06.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.practical06.dao.GenreDao;
import hei.devweb.practical06.entities.Genre;

public class GenreDaoImpl implements GenreDao{

	@Override
	public List<Genre> listGenres() {
		String query = "SELECT * FROM genre ORDER BY name";
		List<Genre> genres = new ArrayList<>(); 
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						Genre genre = new Genre(resultSet.getInt("genre_id"), resultSet.getString("name"));
						genres.add(genre);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}

	@Override
	public Genre getGenre(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM genre WHERE genre_id = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						return new Genre(resultSet.getInt("genre_id"), resultSet.getString("name"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Genre addGenre(String nom) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO genre(name) VALUES(?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, nom);
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						return new Genre(resultSet.getInt(1), nom);
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
