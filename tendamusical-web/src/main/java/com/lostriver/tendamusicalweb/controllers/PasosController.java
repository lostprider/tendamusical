/**
 * 
 */
package com.lostriver.tendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lostriver.tendamusicalweb.session.SessionBean;
import com.lostriver.tendamusicalweb.utils.CommonUtils;

/**
 * @author lostriver
 *
 */
@ManagedBean
@ViewScoped
public class PasosController {
	
	private static final Logger LOGGER = LogManager.getLogger(PasosController.class);
	
	
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	
	@PostConstruct
	public void init() {
		
		LOGGER.info("accedint a PasosController");
		
	}
	
	public void cambiarPaso(String url, int paso) {
		
		try {
			this.sessionBean.setPaso(paso);
			CommonUtils.redireccionar(url);
		} catch (IOException e) {
			
			
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "hi hagut un problema per entrar al pagament de la compra ");
			e.printStackTrace();
		}
		
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}	

}
