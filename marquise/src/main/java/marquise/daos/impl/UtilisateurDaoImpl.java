package marquise.daos.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import marquise.daos.UtilisateurDao;
import marquise.projos.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	@Override
	public List<Utilisateur> listeUtilisateurs() {
		
		String query = "select * from marquiseBase.utilisateurs;";
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
