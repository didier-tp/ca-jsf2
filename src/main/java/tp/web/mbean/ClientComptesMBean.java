package tp.web.mbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tp.web.data.Client;
import tp.web.data.Compte;
import tp.web.data.Login;
import tp.web.service.ServiceComptes;

@ManagedBean //ou @Component si spring
@SessionScoped //ou @Scope("session") si spring
public class ClientComptesMBean {
	
	//@Autowired
	@ManagedProperty("#{serviceComptes}")//equivalent jsf de @Autowired de Spring
	private ServiceComptes serviceComptes; //+get/set attendu par jsf
	
	//private Long numClient ; // ancienne version
	//private String password; // ancienne version
	
	private Login login = new Login(); //avec sous parties .numClient et .password
	
	private Client client; //à afficher
	private List<Compte> comptes; //à afficher sous forme de tableau
	
	public String doLogin() {
		String suite=null;
		if(! this.serviceComptes.verifPassword(login.getNumClient(), login.getPassword())) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("echec authentification"));
		}else {
			this.client = serviceComptes.getInfoClient(login.getNumClient());
			this.comptes = serviceComptes.getComptesClient(login.getNumClient());
			//+ eventuel try/catch , + eventuel if(...)
			suite = "comptes"; //pour demander à naviguer vers comptes.xhtml (navig par defaut JSF2)
		}
		return suite;
	}

	public ServiceComptes getServiceComptes() {
		return serviceComptes;
	}

	public void setServiceComptes(ServiceComptes serviceComptes) {
		this.serviceComptes = serviceComptes;
	}



	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	

}
