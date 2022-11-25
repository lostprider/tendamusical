/**
 * 
 */
package com.lostriver.tendamusicalservices.service;
import java.util.List;

import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;

/**
 * @author lostriver
 *
 */
public interface HomeService {
	
	List<ArtistaAlbumDTO>  consultarAlbumsFiltro(String filtro);

}
