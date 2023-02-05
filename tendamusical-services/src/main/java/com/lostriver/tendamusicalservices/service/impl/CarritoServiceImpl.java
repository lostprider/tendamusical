/**
 * 
 */
package com.lostriver.tendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostriver.tendamusicaldata.dao.CarritoAlbumDAO;
import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;
import com.lostriver.tendamusicalentities.entities.Carrito;
import com.lostriver.tendamusicalentities.entities.CarritoAlbum;
import com.lostriver.tendamusicalservices.service.CarritoService;

/**
 * @author lostriver
 *
 */

@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired
	private CarritoAlbumDAO carritoAlbumDAO;

	@Override
	public CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSelecccionada) {

		CarritoAlbum carritoAlbum = new CarritoAlbum();

		carritoAlbum.setAlbum(artistaAlbumDTO.getAlbum());
		carritoAlbum.setCarrito(carrito);
		carritoAlbum.setCantidad(cantidadAlbumSelecccionada);
		carritoAlbum.setEstatus("PENDENT");

		this.carritoAlbumDAO.save(carritoAlbum);
		
		return carritoAlbum;

	}

	@Override
	public double calcularTotal(Carrito carrito) {
		
		 float total = 0.0F;
		 
		 for (CarritoAlbum carritoAlbum : carrito.getCarritosAlbum()) {
			 
			 total += (carritoAlbum.getAlbum().getValor() * carritoAlbum.getCantidad());
			
		}
		
		
		return total;
	}

	@Override
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
	    this.carritoAlbumDAO.delete(carritoAlbum);
		
	}

	@Override
	public float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito) {
	  
		this.carritoAlbumDAO.save(carritoAlbum);
		
		return (float) this.calcularTotal(carrito);
	}

	


}
