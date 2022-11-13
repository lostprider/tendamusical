/**
 * 
 */
package com.lostriver.tendamusicaldata.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author lostriver classe generica que representa els metodes del CRUD que es
 *         reutilitzant en totes les entitats del projecte. E - Significa la
 *         entitat a utilitzar en el CRUD R - Significa el repositori a
 *         utilitzar de JPA per executar el CRUD.
 */
public class commonDAO<E, R extends PagingAndSortingRepository<E, Long>> {

	@Autowired
	protected R repository;

	/**
	 * Metode que permet consultar una llista de dades paginable d'una entitat
	 * 
	 * @param desde   {@link Integer} indica a partir de quin valor s'obtindra els
	 *                resultats.
	 * @param hasta   {@link Integer} indica el limit de resultats a obtindre.
	 * @param orderBy {@link String} indica a partir de quin camp s'ordenara els
	 *                resultats.
	 * @return {@link List } llista em les dades consultades paginades.
	 */
	public List<E> consultarLlistaPaginable(int desde, int hasta, String orderBy) {

		Pageable pageable = PageRequest.of(desde, hasta, Sort.by(orderBy));
		Page<E> page = this.repository.findAll(pageable);
		return page.getContent();

	}

	/**
	 * Metode que permet persistir la informaci� de qualsevol entitat.
	 * 
	 * @param e {@link Object} objecte o entitat a guardar
	 * @return {@link Object} objecte recuperat despres de ser guardat al registre
	 */
	public E guardar(E e) {

		return this.repository.save(e);

	}

	/**
	 * Metode que permet modificar la informaci� de qualsevol entitat.
	 * 
	 * @param e {@link Object} objecte o entitat a modificar
	 * @return {@link Object} objecte recuperat despres de ser modificat al registre
	 */
	public E actualitzar(E e) {

		return this.repository.save(e);

	}

	/**
	 * Metode que permet eliminar la informaci� de qualsevol entitat.
	 * 
	 * @param e {@link Object} objecte o entitat a eliminar
	 * 
	 */
	public void eliminar(E e) {

		this.repository.delete(e);

	}

}
