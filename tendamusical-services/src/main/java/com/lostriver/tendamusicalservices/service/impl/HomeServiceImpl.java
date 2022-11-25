/**
 * 
 */
package com.lostriver.tendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostriver.tendamusicaldata.dao.ArtistaDAO;
import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;

import com.lostriver.tendamusicalservices.service.HomeService;


/**
 * @author lostriver
 *
 */

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private ArtistaDAO artistaDAOImpl;

	@Override
	public List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro) {
		// TODO Auto-generated method stub
		return this.artistaDAOImpl.consultarArtistasAlbumsPorFiltro(filtro);
	}

	

}
