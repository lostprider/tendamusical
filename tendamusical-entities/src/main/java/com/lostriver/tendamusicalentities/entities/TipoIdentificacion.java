/**
 * 
 */
package com.lostriver.tendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lostriver
 *Classe que cont� entitats del tipus de identificaci� d'una persona o usuari
 */

@Entity
@Table(name = "tipoidentificacion")
public class TipoIdentificacion extends Common {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipoIdentificacion")
	private Long idTipoIdentifacion;

	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;

	/**
	 * @return the idTipoIdentifacion
	 */
	public Long getIdTipoIdentifacion() {
		return idTipoIdentifacion;
	}

	/**
	 * @param idTipoIdentifacion the idTipoIdentifacion to set
	 */
	public void setIdTipoIdentifacion(Long idTipoIdentifacion) {
		this.idTipoIdentifacion = idTipoIdentifacion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
