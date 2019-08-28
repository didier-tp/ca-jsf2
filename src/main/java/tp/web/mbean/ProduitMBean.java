package tp.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import tp.web.data.Produit;
import tp.web.service.ServiceProduits;

@ManagedBean
@SessionScoped
public class ProduitMBean {
	
	private List<String> categories; //liste de categorie (à choisir)
	private String categorie;//catégorie selectionnée
	private List<Produit> produits = new ArrayList<Produit>(); //liste des produits de la catégorie sélectionnée
	private Long idProduit; //id produit selectionné
	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	private Produit produit; //produit sélectionné à détailler
	
	//@Autowired
	@ManagedProperty("#{serviceProduits}")
	private ServiceProduits serviceProduits /*=null*/;
	
	public ProduitMBean(){
		//this.categories = serviceProduits.getCategories();
		System.out.println("dans constructeur de ProduitMBean , serviceProduits"+serviceProduits);
	}

	@PostConstruct
	public void init() {
		this.categories = serviceProduits.getCategories();
		System.out.println("categories="+categories);
	}
	
	public void onCategorieChange(ValueChangeEvent event){
        this.categorie = (String) event.getNewValue();
        this.produits = serviceProduits.getProduitsCategorie(categorie);
	}
	
	public void onProduitChange(ValueChangeEvent event){
        this.idProduit = (Long) event.getNewValue();
        System.out.println("id produit selectionne:" + idProduit);
        for(Produit p : this.produits) {
        	if(p.getNumero() == this.idProduit) {
        		this.produit = p; break;
        	}
        }
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public ServiceProduits getServiceProduits() {
		return serviceProduits;
	}

	public void setServiceProduits(ServiceProduits serviceProduits) {
		this.serviceProduits = serviceProduits;
	}
	
	
	
}
