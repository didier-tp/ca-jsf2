package tp.web.data;

public class Produit {
	
	private Long numero;
	private String label;
	private Double prix;
	private String caracteristiques;
	//...
	
	public Produit(Long numero, String label, Double prix, String caracteristiques) {
		super();
		this.numero = numero;
		this.label = label;
		this.prix = prix;
		this.caracteristiques = caracteristiques;
	}
	
	
	public Produit() {
		super();
	}



	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getCaracteristiques() {
		return caracteristiques;
	}
	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	
	

}
