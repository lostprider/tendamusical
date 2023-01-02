/**
 * 
 */
package com.lostriver.tendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;
import com.lostriver.tendamusicalentities.entities.CarritoAlbum;
import com.lostriver.tendamusicalservices.service.CarritoService;
import com.lostriver.tendamusicalweb.session.SessionBean;

/**
 * @author lostriver
 *
 */

@ManagedBean
@ViewScoped
public class DetallController {
	
	private static final Logger LOGGER = LogManager.getLogger(DetallController.class);
	
	
	
	
	/**
	 * Quantitat del producte seleccionat
	 */
	private int cantidadAlbumSeleccionada;
	
	
	/**
	 * Objecte que conte els metodes de la logica de negoci del carro de la compra.
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	
	/**
	 * objecte que conte la informacio de la sessió de l'usuari
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	
	/**
	 * Inicialitza la pantalla del detall
	 */
	@PostConstruct
	public void init() {
		
		this.cantidadAlbumSeleccionada = 1;
		
	}
	
	
	/**
	 * Metode que permet agregar el album seleccionat al carro de la compra
	 * @param artistaAlbumDTO
	 */
	public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
		
		LOGGER.info("Agregant album al carro de compres....." +  ", Quantitat:" + this.cantidadAlbumSeleccionada);

		CarritoAlbum carritosAlbumAgregado = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDTO, this.sessionBean.getPersona().getCarrito(), cantidadAlbumSeleccionada);
		
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritosAlbumAgregado);
		
		
		
	}


	public int getCantidadAlbumSeleccionada() {
		return cantidadAlbumSeleccionada;
	}


	public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
		this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
	}


	public static Logger getLogger() {
		return LOGGER;
	}


	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}


	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
	}


	public SessionBean getSessionBean() {
		return sessionBean;
	}


	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
