/**
 * 
 */
package com.lostriver.tendamusicaldata.dao.impl;




import org.springframework.stereotype.Repository;

import com.lostriver.tendamusicaldata.dao.PersonaDAO;
import com.lostriver.tendamusicalentities.entities.Persona;
import com.lostriver.tendamusicaldata.common.commonDAO;

/**
 * @author lostriver
 * Clase que implemente el CRUD generic i les funcions de la interface de PersonaDAO
 *
 */
@Repository
public class PersonaDAOImpl extends commonDAO<Persona, PersonaDAO> {
	
	/**
	 * Metode que permet consultar una persona per el seu usuari i contrasenya
	 * @param usuario  {@link String} usuari capturat per la persona
	 * @param password {@link String} password capturat per la persona
	 * @return {@link Persona}  persona trobada
	 */
	
	public Persona findUsuariAndPassword(String usuario, String password) {
		
		return this.repository.findbyUsuariAndPassword(usuario, password);
		
	}

}
