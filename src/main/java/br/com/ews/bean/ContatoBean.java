package br.com.ews.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * http://localhost:8080/bean-validation-example/  
 **/
@Named
@RequestScoped
public class ContatoBean {
	
	@NotNull(message="O campo email e obrigatorio")
	@Size(min = 5, max= 20, message="Tamanho email invalido! Favor digitar entre 5 e 20 caracteres.")
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Email invalido!")
	private String email;
	
	@Cep
	private String cep;
	

	public String enviaEmail() {
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage("Email " + email + " enviado com sucesso!"));
		System.out.println("ENVIANDO EMAIL: " + email);
		return "";
	}
	
	//---------------------- getter's setter's -------------------------------//
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}