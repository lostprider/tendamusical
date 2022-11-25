/**
 * 
 */
package com.lostriver.tendamusicalentities.dto;

import com.lostriver.tendamusicalentities.entities.Album;
import com.lostriver.tendamusicalentities.entities.Artista;

/**
 * @author lostriver
 *
 */
public class ArtistaAlbumDTO {
	
	
	/**
	 * objecte que conte la infromació del artista
	 */
	private Artista artista;
	
	/**
	 * objecte que conte la infromació del artista
	 */
	
	private Album album;
	
	
	public ArtistaAlbumDTO() {
		super();
	}
	/**
	 * Construcro que inicialityza la informació consultada per buscar de albums;
	 * @param album
	 * @param artista
	 */
	
	public ArtistaAlbumDTO(Album album, Artista artista) {
		 
		
		this.album = album;
		this.artista = artista;

	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	


}
