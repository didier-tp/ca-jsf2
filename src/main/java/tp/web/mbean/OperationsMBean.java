package tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ComponentSystemEvent;

//dernieres operations sur compte
@ManagedBean
@RequestScoped
public class OperationsMBean {
	private Long numCpt; //+get/set
	private String message;//+get/set
	
	public void initOperations(ComponentSystemEvent event){
		this.message="dernieres operations du compte" + numCpt;
	}
	
	public Long getNumCpt() {
		return numCpt;
	}
	public void setNumCpt(Long numCpt) {
		this.numCpt = numCpt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
