package marquise.dao;

public interface LicencieDao {
	
	public List<Licencie> listLicencies();
	
	public Licencie getPayment(boolean bol);
	
	public Licencie addLicencie(String nom, String prenom);
	

}
