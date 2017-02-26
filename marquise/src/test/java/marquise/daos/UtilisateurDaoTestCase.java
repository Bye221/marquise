
package marquise.daos;

import java.sql.Connection;
import java.sql.Statement;

import marquise.daos.UtilisateurDao;
import marquise.daos.impl.DataSourceProvider;
import marquise.daos.impl.UtilisateurDaoImpl;
import marquise.daos.mock.impl.UtilisateurDaoMockImpl;

public class UtilisateurDaoTestCase {
	
	private UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
	
	
	public void initDb() throws Exception{
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement stmt = connection.createStatement()){
					stmt.executeUpdate("delete from informations");
					stmt.executeUpdate("delete from utilisateurs");
					stmt.executeUpdate("INSERT INTO `marquiseBase`.`utilisateurs` (`idUtilisateurs`, `nom`, `prenom`) VALUES ('1', 'auvray', 'louis-come');"
);
					
				}
	}
	

}
