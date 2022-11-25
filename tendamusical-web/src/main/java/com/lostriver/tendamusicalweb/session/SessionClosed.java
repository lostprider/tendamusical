/**
 * 
 */
package com.lostriver.tendamusicalweb.session;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.lostriver.tendamusicalweb.utils.CommonUtils;

/**
 * @author lostriver
 *
 */

@ManagedBean
@ViewScoped
public class SessionClosed {
	
	public void cerrarSesion() {
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			CommonUtils.redireccionar("/login.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "UPS!", "Hi hagut un probelma al tancar la sessió");
			e.printStackTrace();
		}
	}

}
