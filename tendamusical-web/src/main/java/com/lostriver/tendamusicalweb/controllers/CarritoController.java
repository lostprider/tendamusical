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

import com.lostriver.tendamusicalentities.entities.CarritoAlbum;
import com.lostriver.tendamusicalservices.service.CarritoService;
import com.lostriver.tendamusicalweb.session.SessionBean;

/**
 * @author lostriver
 *
 */

@ManagedBean
@ViewScoped
public class CarritoController {

	private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);

	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;

	@PostConstruct
	public void init() {

		this.calcularTotal();

	}

	public void calcularTotal() {
		
		LOGGER.info("Calculant el total de les compres de " + this.sessionBean.getPersona().getNombre() );
		
		float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());
		
		this.sessionBean.setTotalCompra(total);
		

	}
	
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		
		LOGGER.info("Eliminant album " + carritoAlbum.getAlbum().getNombre() +  " del carro de la compra de " + this.sessionBean.getPersona().getNombre());
		
		this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
		
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
		
		this.calcularTotal();
	}
	
	public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
		
		float totalCompra = this.carritoServiceImpl.actualizarAlbumCantidad(carritoAlbum, this.sessionBean.getPersona().getCarrito());
		
		this.sessionBean.setTotalCompra(totalCompra);
		
		
		
		
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
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

}
