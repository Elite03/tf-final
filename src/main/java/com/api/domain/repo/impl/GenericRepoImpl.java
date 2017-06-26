package com.api.domain.repo.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import com.api.domain.repo.GenericRepositiry;

public class GenericRepoImpl<T, ID extends Serializable> implements GenericRepositiry<T, ID> {

	@PersistenceContext
	protected EntityManager em;

	private final Class<T> entityClass;

	public GenericRepoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T findById(ID id) {
		return this.findById(id, LockModeType.NONE);
	}

	@Override
	public T findById(ID id, LockModeType lock) {
		return em.find(entityClass, id, lock);
	}

	@Override
	public T getReferenceById(ID id) {
		return em.getReference(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> c = em.getCriteriaBuilder().createQuery(entityClass);
		c.select(c.from(entityClass));
		return em.createQuery(c).getResultList();
	}

}
