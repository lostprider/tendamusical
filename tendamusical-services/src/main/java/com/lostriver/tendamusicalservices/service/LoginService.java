/**
 * 
 */
package com.lostriver.tendamusicalservices.service;



import com.lostriver.tendamusicalentities.entities.Persona;

/**
 * @author lostriver
 * interfaz que realitza la logica de negoci per el inici de sessi� de la persona.
 */

public interface LoginService {
	
	/**
	 * Metode que permet consultar un usuari que tracta d'ingressar a la sessi� de la tenda musical
	 * @param usuari {@link String} usuari capturat per la persona
	 * @param password {@link String} contrasenya capturada per la persona
	 * @return {@link Persona} usuari trobat a la base de dades.
	 */
	Persona consultarUsuariLogin(String usuario, String password);

}
