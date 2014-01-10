package com.kairos.ebillquezelco.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Implementation class of GenericDao interface
 * @author jbonifacio
 *
 * @param <T> JPA Entity Class
 * @param <E> Class of the ID (primary-key) of the JPA Entity Class 
 */
public class GenericDaoImpl<T extends Serializable, E> implements GenericDao<T, E> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public T create(T object) {
		entityManager.persist(object);
		return object;
	}

	@Override
	public void delete(E pk) {
		entityManager.remove(entityManager.getReference(type, pk));
	}

	@Override
	public T update(T object) {
		return entityManager.merge(object);
	}

	@Override
	public T getById(E pk) {
		return (T) entityManager.find(type, pk);
	}

	@Override
	public List<T> getAll() {
		return entityManager.createQuery("SELECT c FROM " + getEntityName() + " c", type).getResultList();
	}

	@Override
	public Long count() {
		try {
			return (Long) entityManager.createQuery("SELECT count(c) FROM " + getEntityName() + " c", type).getSingleResult();
		} catch (NoResultException e) {
			return new Long(0);
		}
	}

	private String entity;

	private String getEntityName() {
		if(entity==null) {
			Entity entityAnn = (Entity) type.getAnnotation(Entity.class);
			entity = (entityAnn != null && !entityAnn.name().equals("")) ? 
					entityAnn.name() : type.getSimpleName() ;
		}
		return entity;
	}
	
}
