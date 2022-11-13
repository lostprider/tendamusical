/**
 * 
 */
package com.lostriver.tendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lostriver.tendamusicalentities.entities.Persona;
import com.lostriver.tendamusicalservices.service.LoginService;
import com.lostriver.tendamusicalweb.utils.CommonUtils;

/**
 * @author lostriver controlador que s'encarrega del fluxe de la pantalla del
 *         login.xhtml
 */

@ManagedBean
@ViewScoped

public class LoginController {
	/**
	 * Usuari capturat per la persona.
	 */
	
	private String usuario;

	/**
	 * contrasenya capturada per la persona.
	 */

	private String password;
	
	/**
	 * Propietat de la logica de negoci injectada amb JSF y Spring
	 *
	 */
	
	@ManagedProperty("#{loginServiceImpl}")
	
	public LoginService loginServiceImpl;

	@PostConstruct
	public void init() {

		System.out.println("Inicialitzant el login......");

	}

	/**
	 * Metode que permet a la persona, entrar a la seva pantalla principal
	 */
    
	public void entrar() {
		
		Persona personaConsultada = this.loginServiceImpl.consultarUsuariLogin(this.usuario, this.password);

		if (personaConsultada !=null) {
			
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "EXITÓS!", "Benvingut a la teva pantalla principal");	
			
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "El usuari y/o contrasenya son erronis ");
		}

	}

	/**
	 * @return the usuari
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuari the usuari to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginServiceImpl
	 */
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	/**
	 * @param loginServiceImpl the loginServiceImpl to set
	 */
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

	

}
