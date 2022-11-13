/**
 * 
 */
package com.lostriver.tendamusicalweb.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
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

}
