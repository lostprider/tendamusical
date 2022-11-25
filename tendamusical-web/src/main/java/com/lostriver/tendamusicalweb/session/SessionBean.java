/**
 * 
 */
package com.lostriver.tendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lostriver.tendamusicalentities.entities.Persona;

/**
 * @author lostriver
 * 
 * classe que mantindra la informació en la sessió del usuari.
 *
 */

@ManagedBean
@SessionScoped
public class SessionBean {
	
	/**
	 * Objecte Persona que es mantindra en la sessió.
	 */
	private Persona persona;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Creant sessió.....");
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
