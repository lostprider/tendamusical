/**
 * 
 */
package com.lostriver.tendamusicaldata.dao;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;



import com.lostriver.tendamusicalentities.entities.Persona;



/**
 * @author lostriver
 * Interface DAO que realitza el CRUD amb springJPA per la taula persona.
 *
 */


public interface PersonaDAO  extends PagingAndSortingRepository <Persona, Long> {
	/**
	 * 
	 * Metode que permet consultar el usuari que entra a la sessi�
	 * @param usuario {@link String} usuari capturat per la persona
	 * @param password{@link String} password capturat per la persona
	 * @return {@link Persona} objecte em la persona trobada
	 */
	@Query("SELECT p FROM Persona p WHERE p.usuario = ?1 AND p.password = ?2")
	Persona findbyUsuariAndPassword(String usuario, String password);
	
	

}
