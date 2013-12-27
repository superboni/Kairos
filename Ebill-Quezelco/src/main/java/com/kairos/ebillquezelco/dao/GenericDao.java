package com.kairos.ebillquezelco.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface of Methods common to all JPA DAOs
 * @author jbonifacio
 *
 * @param <T> JPA Entity Class
 * @param <E> Class of the ID (primary-key) of the JPA Entity Class 
 */
public interface GenericDao<T extends Serializable, E> {
	
	/**
	 * Creates a new JPA Object
	 */
	public T create(T object);
	
	/**
	 * Deletes the JPA Object by its Primary Key
	 */
	public void delete(E pk);
	
	/**
	 * Updates an existing JPA Object
	 */
	public T update(T object);
	
	/**
	 * Finds the JPA Object by its Primary Key
	 */
	public T getById(E pk);
	
	/**
	 * Returns all records in the Table
	 */
	public List<T> getAll();
	
	/**
	 * Count of all records in the Table
	 */
	public Long count();
	
}