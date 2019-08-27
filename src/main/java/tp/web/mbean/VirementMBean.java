package tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import tp.web.service.ServiceComptes;

@ManagedBean
@RequestScoped
public class VirementMBean {
	
	private Long numCptDeb; //à sélectionner via liste dérourante
	private Long numCptCred;//à sélectionner via liste dérourante
	private Double montant;//à saisir
	
	@ManagedProperty("#{serviceComptes}")//equivalent jsf de @Autowired de Spring
	private ServiceComptes serviceComptes; //+get/set attendu par jsf
	
	@ManagedProperty("#{clientComptesMBean}") //en SessionScoped (dure longtemps)
	private ClientComptesMBean clientComptesMBean; //avec get/set
	
	public String virement() {
		String suite = null;
		//deleguer le virement au service
		Long numClient = clientComptesMBean.getNumClient();
		serviceComptes.effectuerVirementInterne(numClient, montant, numCptDeb, numCptCred);
		//si ok , réactualiser liste des comptes dans clientComptesMBean
		clientComptesMBean.setComptes(serviceComptes.getComptesClient(numClient));
		       // et naviguer vers comptes
		suite="comptes"; //naviguer vers comptes.xhtml
		//si exception,
		       //afficher message erreur
		return suite;
	}

	public Long getNumCptDeb() {
		return numCptDeb;
	}

	public void setNumCptDeb(Long numCptDeb) {
		this.numCptDeb = numCptDeb;
	}

	public Long getNumCptCred() {
		return numCptCred;
	}

	public void setNumCptCred(Long numCptCred) {
		this.numCptCred = numCptCred;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public ServiceComptes getServiceComptes() {
		return serviceComptes;
	}

	public void setServiceComptes(ServiceComptes serviceComptes) {
		this.serviceComptes = serviceComptes;
	}

	public ClientComptesMBean getClientComptesMBean() {
		return clientComptesMBean;
	}

	public void setClientComptesMBean(ClientComptesMBean clientComptesMBean) {
		this.clientComptesMBean = clientComptesMBean;
	}
	
	

}
