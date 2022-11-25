/**
 * 
 */
package com.lostriver.tendamusicalentities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author lostriver
 *
 */

@Entity

@Table(name = "album")
public class Album extends Common{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlbum")
	private Long idAlbum;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "imagen", length = 100, nullable = false)
	private String imagen;
	
	
	@Column(name = "descripcion", length = 60, nullable = false)
	private String descripcion;

	@Column(name = "anio", nullable = false)
	private int año;
	
	@Column(name = "formato", length = 10, nullable = false)
	private String formato;
	
	@Column(name = "valor", nullable = false)
	private double valor;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idDisquera")
	private Disquera disquera;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idArtista")
	private Artista artista;
	
	@Column(name = "raiting")
	private Integer raiting;

	public Long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Disquera getDisquera() {
		return disquera;
	}

	public void setDisquera(Disquera disquera) {
		this.disquera = disquera;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}

}
