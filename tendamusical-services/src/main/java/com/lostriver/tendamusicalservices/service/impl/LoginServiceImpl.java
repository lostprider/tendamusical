/**
 * 
 */
package com.lostriver.tendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostriver.tendamusicaldata.dao.PersonaDAO;
import com.lostriver.tendamusicalentities.entities.Persona;
import com.lostriver.tendamusicalservices.service.LoginService;

/**
 * @author lostriver clase que implementa les funcions per la logica de negoci
 *         per el login.
 *
 */

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private PersonaDAO personaDAOImpl;

	@Override
	public Persona consultarUsuariLogin(String usuario, String password) {

		return this.personaDAOImpl.findbyUsuariAndPassword(usuario, password);

	}

}
