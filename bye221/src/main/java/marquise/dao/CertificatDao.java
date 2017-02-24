package marquise.dao;

import java.util.List;

public interface CertificatDao {
	
	
	public List <Certificat> listCertificats();
	
	public Certificat getCertificatDonne(Boolean oui );
	
	public Certificat getCertificatPapier( );
		
	

}
