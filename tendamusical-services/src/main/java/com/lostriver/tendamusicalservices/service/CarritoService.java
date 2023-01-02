/**
 * 
 */
package com.lostriver.tendamusicalservices.service;

import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;
import com.lostriver.tendamusicalentities.entities.Carrito;
import com.lostriver.tendamusicalentities.entities.CarritoAlbum;

/**
 * @author lostriver
 *
 */
public interface CarritoService {
	
	
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSelecccionada);

	
	float calcularTotal(Carrito carrito);
	
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);
}
