/**
 * 
 */
package com.lostriver.tendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lostriver.tendamusicalentities.dto.ArtistaAlbumDTO;
import com.lostriver.tendamusicalentities.entities.Persona;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;

/**
 * @author lostriver
 * 
 * classe que mantindra la informació en la sessió del usuari.
 *
 */

@ManagedBean
@SessionScoped
public class SessionBean {
	
	/**
	 * Objecte Persona que es mantindra en la sessió.
	 */
	private Persona persona;
	
	/**
	 * objecte que conté la informació del detall del album
	 */
    private ArtistaAlbumDTO artistaAlbumDTO;
    
    private float totalCompra;
    
    private HttpResponse<Order> order;
    
    private int paso;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Creant sessió.....");
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public ArtistaAlbumDTO getArtistaAlbumDTO() {
		return artistaAlbumDTO;
	}

	public void setArtistaAlbumDTO(ArtistaAlbumDTO artistaAlbumDTO) {
		this.artistaAlbumDTO = artistaAlbumDTO;
	}

	public float getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}

	public void setOrder(HttpResponse<Order> response) {
	    this.order = response;
		
	}

	public HttpResponse<Order> getOrder() {
		return order;
	}

	public int getPaso() {
		return paso;
	}

	public void setPaso(int paso) {
		this.paso = paso;
	}
	
	

}
