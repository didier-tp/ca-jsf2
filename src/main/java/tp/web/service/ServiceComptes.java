package tp.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tp.web.data.Client;
import tp.web.data.Compte;

//@Component ou @Service sur projet Spring
@ManagedBean //plus proche equivalent jsf de @Component spring
@ApplicationScoped //proche singeton Spring , Simulation sans base de données
public class ServiceComptes {
	private Map<Long,Client> mapClients =  new HashMap<Long,Client>();
	private Map<Long,List<Compte>> mapComptes =  new HashMap<Long,List<Compte>>();
	
	public ServiceComptes() {
		mapClients.put(1L,new Client(1L,"bon","jean"));
		List<Compte> comptesDuClient1 = new ArrayList<Compte>();
		comptesDuClient1.add(new Compte(11L,"compte courant 11", 150.50));
		comptesDuClient1.add(new Compte(12L,"compte epargne 12", 50.50));
		mapComptes.put(1L,comptesDuClient1);
		
		mapClients.put(2L,new Client(2L,"therieur","alex"));
		List<Compte> comptesDuClient2 = new ArrayList<Compte>();
		comptesDuClient2.add(new Compte(21L,"compte courant 21", 250.50));
		comptesDuClient2.add(new Compte(22L,"compte epargne 22", 350.50));
		mapComptes.put(2L,comptesDuClient2);
	}
	
	public Client getInfoClient(Long numClient) {
		return mapClients.get(numClient);
	}
	
	public List<Compte> getComptesClient(Long numClient){
		return mapComptes.get(numClient);
	}
	
	public boolean verifPassword(Long numClient,String pwd) {
		return pwd.equals("pwd"+numClient); //simulation
		//ok pour 1 et pwd1 , 2 et pwd2
	}

}
