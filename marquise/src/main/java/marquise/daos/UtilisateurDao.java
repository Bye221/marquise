package marquise.daos;

import java.util.List;
import marquise.projos.Utilisateur;

public interface UtilisateurDao {
	
	
	
	public List<Utilisateur> listeUtilisateurs();
	
	public Utilisateur getUtilisateur(Integer id);
	
	public Utilisateur addUtilisateur(Integer id, String nom, String Prenom);

}
