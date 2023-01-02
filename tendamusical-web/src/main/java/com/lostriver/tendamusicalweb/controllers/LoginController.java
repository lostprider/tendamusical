/**
 * 
 */
package com.lostriver.tendamusicalweb.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lostriver.tendamusicalentities.entities.CarritoAlbum;
import com.lostriver.tendamusicalentities.entities.Persona;
import com.lostriver.tendamusicalservices.service.LoginService;
import com.lostriver.tendamusicalweb.session.SessionBean;
import com.lostriver.tendamusicalweb.utils.CommonUtils;

/**
 * @author lostriver controlador que s'encarrega del fluxe de la pantalla del
 *         login.xhtml
 */

@ManagedBean
@ViewScoped

public class LoginController {
	
	
	/**
	 * Objecte que permet mostrar els missatges de LOG en la consola del servidor o en un arxiu extern.
	 */
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
	
	
	
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
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	@PostConstruct
	public void init() {

		System.out.println("Inicialitzant el login......");

	}

	/**
	 * Metode que permet a la persona, entrar a la seva pantalla principal
	 * 
	 * 
	 */

	public void entrar() {

		Persona personaConsultada = this.loginServiceImpl.consultarUsuariLogin(this.usuario, this.password);
        
		
		if (personaConsultada != null) {

			try {
				
				
				List<CarritoAlbum> carritoAlbumsFiltrados = personaConsultada.getCarrito().getCarritosAlbum().stream().filter(ca -> ca.getEstatus().equals("PENDENT")).collect(Collectors.toList());
				
				
				personaConsultada.getCarrito().setCarritosAlbum(carritoAlbumsFiltrados);
				
				
				LOGGER.info("Albums del carrito filtrados....");
				
				this.sessionBean.setPersona(personaConsultada);
				
				
				
				CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
			} catch (IOException e) {
				
				e.printStackTrace();
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "ERROR!", "Format incorrecte en el cual s'ingressa a la pantalla ");
			}

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

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
