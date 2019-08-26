package tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//mbean = Managed Bean du framework JSF

@ManagedBean //name par defaut = "empruntMBean"
@RequestScoped  //ou SessionScoped
public class EmpruntMBean {
	
	private Double montant;
	private Double taux; //annuel
	private Integer nbMois;
	
	private Double mensualite;
	
	public String calculer() {
		String suite=null;
		double tauxMensuel = taux / 12;
		this.mensualite = 
				this.montant * tauxMensuel / (1 - Math.pow(1.0+tauxMensuel,-this.nbMois));
		return suite; //null (rester sur meme page) ou "pageXy" pour naviguer 
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public Integer getNbMois() {
		return nbMois;
	}

	public void setNbMois(Integer nbMois) {
		this.nbMois = nbMois;
	}

	public Double getMensualite() {
		return mensualite;
	}

	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}
	
	
	
}
