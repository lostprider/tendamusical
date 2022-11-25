/**
 * 
 */
package com.lostriver.tendamusicalweb.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author lostriver
 * 
 * Classes generada per crear funcions globals o comuns entre classes del projecte tendamusical
 *
 */
public class CommonUtils {
	/**
	 * Metode que permet mostrar un missatge al usuari.
	 * @param severity {@link Severity} objecte que indica el tipus de missatge a mostrar.
	 * @param summary {@link String} titol del missatge.
	 * @param detail {@link String} detall del missatge
	 */
	
	public static void mostrarMensaje(Severity severity, String summary, String detail) {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
		
	}
	
	/**
	 * Metode que permet redireccionar paginas
	 * @param url ({@link String} direcció o pantalla a canviar.
	 * @throws IOException {@link IOException} exepció en cas d'error al trobar la pagina
	 */
	public static void redireccionar(String url) throws IOException {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		String contextPath= externalContext.getRequestContextPath();
		
		externalContext.redirect(contextPath + url);
		
		
	}

}
