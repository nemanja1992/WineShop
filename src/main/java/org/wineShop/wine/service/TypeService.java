package org.wineShop.wine.service;

import java.util.List;

import org.wineShop.wine.model.Type;

public interface TypeService {
	List<Type> findAll();
	void save (Type type);
	void remove(Long id);
	Type findOne(Long id);
}
