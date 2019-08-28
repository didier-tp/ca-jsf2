package tp.web.data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

//NB: le code qui verifie @Min @Size est souvent Hibernate-validator
//compatible JSF

public class Login {

	@Min(value = 0 , message="numClient doit etre positif")
	private Long numClient ; 
	
	@Size(min = 4, message = "Mot de passe avec 4 caracteres minimun")
	private String password;
	
	public Long getNumClient() {
		return numClient;
	}
	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	
}
