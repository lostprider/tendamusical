/**
 * 
 */
package com.lostriver.tendamusicaldata.dao.impl;

import java.util.List;

import com.lostriver.tendamusicaldata.common.commonDAO;
import com.lostriver.tendamusicaldata.dao.ArtistaDAO;
import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;
import com.lostriver.tendamusicalentities.entities.Artista;

/**
 * @author lostriver
 *
 */
public class ArtistaDAOImpl extends commonDAO<Artista, ArtistaDAO> {
	
	public List<ArtistaAlbumDTO> consultarArtistaAlbumPorFiltro(String filtro) {
		return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
	}

}
