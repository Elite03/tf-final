package com.api.domain.repo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

public interface GenericRepositiry<T, ID extends Serializable> {

	T findById(ID id);

	T findById(ID id, LockModeType lock);

	T getReferenceById(ID id);

	List<T> findAll();
}
