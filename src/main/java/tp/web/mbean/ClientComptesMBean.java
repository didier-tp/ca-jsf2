package tp.web.mbean;

import java.util.List;

import tp.web.data.Client;
import tp.web.data.Compte;

public class ClientComptesMBean {
	
	private Long numClient ; // à saisir
	private String password; // à saisir
	
	private Client client; //à afficher
	private List<Compte> comptes; //à afficher sous forme de tableau
	
	public String login() {
		String suite=null;
		return suite;
	}

}
