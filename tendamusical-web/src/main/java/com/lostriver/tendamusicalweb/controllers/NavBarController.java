/**
 * 
 */
package com.lostriver.tendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lostriver.tendamusicalweb.utils.CommonUtils;

/**
 * @author lostriver
 *
 */


@ManagedBean
@ViewScoped
public class NavBarController {
	
	private static final Logger LOGGER = LogManager.getLogger(NavBarController.class);
	
	

	@PostConstruct
	public void init() {
		
		LOGGER.info("inicialitzant pantalla del carro de la compra");
		
	}
	
	public void redireccionar() {
		
		try {
			CommonUtils.redireccionar("/pages/client/carrito.xhtml");
		} catch (IOException e) {
			
			
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR!", "hi hagut un problema per entrar al carro de la compra ");
			e.printStackTrace();
		}
		
		
	}
	
	

}
