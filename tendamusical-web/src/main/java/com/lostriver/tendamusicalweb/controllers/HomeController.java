/**
 * 
 */
package com.lostriver.tendamusicalweb.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;
import com.lostriver.tendamusicalservices.service.HomeService;

/**
 * @author lostriver
 *
 */
@ManagedBean
@ViewScoped
public class HomeController {
	
	/**
	 * Objecte que permet mostrar els missatges de LOG en la consola del servidor o en un arxiu extern.
	 */
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
	
	/**
	 * Texto ingresado por el cliente en el buscador.
	 */
	private String filtro;
	/**
	 * Lista obtenida a partir del filtro ingresado en el buscador.
	 */
	private List<ArtistaAlbumDTO> artistasAlbumDTO;
	/**
	 * Se inyecta el objeto de spring con jsf para obtener los metodos de logica de negocio del home.
	 */
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	/**
	 * Inicializando pantalla.
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
		LOGGER.fatal("FATAL");
	}
	/**
	 * Metodo que permite obtener los albums de los artistas encontrados en la base de datos
	 * con respecto al filtro ingresado por el cliente.
	 */
	public void consultarAlbumsArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);
		
		if (this.artistasAlbumDTO != null) {
			this.artistasAlbumDTO.forEach( artistaAlbumDTO -> {
				LOGGER.info("Artista: " + artistaAlbumDTO.getArtista().getNombre());
			});
		}
	}
	
	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}
	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	/**
	 * @return the artistasAlbumDTO
	 */
	public List<ArtistaAlbumDTO> getArtistasAlbumDTO() {
		return artistasAlbumDTO;
	}
	/**
	 * @param artistasAlbumDTO the artistasAlbumDTO to set
	 */
	public void setArtistasAlbumDTO(List<ArtistaAlbumDTO> artistasAlbumDTO) {
		this.artistasAlbumDTO = artistasAlbumDTO;
	}
	/**
	 * @return the homeServiceImpl
	 */
	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}
	/**
	 * @param homeServiceImpl the homeServiceImpl to set
	 */
	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
	}
}

