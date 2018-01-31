package org.wineShop.wine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wineShop.wine.model.Type;
import org.wineShop.wine.repository.TypeRepository;
import org.wineShop.wine.service.TypeService;

@Service
@Transactional
public class JpaTypeServiceImpl implements TypeService{

	@Autowired
	private TypeRepository typeRepository;
	
	@Override
	public List<Type> findAll() {
		return typeRepository.findAll();
	}

	@Override
	public void save(Type type) {
		typeRepository.save(type);
		
	}

	@Override
	public void remove(Long id) {
		typeRepository.delete(id);
		
	}

	@Override
	public Type findOne(Long id) {
		return typeRepository.findOne(id);
	}

}
