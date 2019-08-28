package tp.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tp.web.data.Client;
import tp.web.data.Compte;
import tp.web.data.Produit;

//@Component ou @Service sur projet Spring
@ManagedBean //plus proche equivalent jsf de @Component spring
@ApplicationScoped //proche singeton Spring , Simulation sans base de données
public class ServiceProduits {
	private List<String> categories =  new ArrayList<String>();
	private Map<String,List<Produit>> mapProduits =  new HashMap<String,List<Produit>>();
	
	public ServiceProduits() {
		categories.add("CD"); categories.add("DVD"); categories.add("Divers");
		categories.add("C1"); categories.add("C2"); categories.add("C3");
		
		List<Produit> produitsCD = new ArrayList<Produit>();
		produitsCD.add(new Produit(11L,"CD 1", 14.50 , "CD Alain Souchon"));
		produitsCD.add(new Produit(12L,"CD 2", 8.50 , "CD Xyz"));
		mapProduits.put("CD",produitsCD);
		List<Produit> produitsDVD = new ArrayList<Produit>();
		produitsDVD.add(new Produit(21L,"DVD 1", 20.50 , "DVD Film 1"));
		produitsDVD.add(new Produit(22L,"DVD 2", 18.50 , "DVD Film 2"));
		mapProduits.put("DVD",produitsDVD);
		List<Produit> produitsDivers = new ArrayList<Produit>();
		produitsDivers.add(new Produit(31L,"Cahier", 2.50 , "cahier grands carreaux"));
		produitsDivers.add(new Produit(32L,"stylo", 1.50 , "Stylo bille bleu"));
		mapProduits.put("Divers",produitsDivers);
	}
	
	public List<String> getCategories() {
		return this.categories;
	}
	
	public List<Produit> getProduitsCategorie(String categorie){
		return mapProduits.get(categorie);
	}
}
