package org.wineShop.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wineShop.wine.model.ShoppingCart;
import org.wineShop.wine.repository.ShoppingCartRepository;
import org.wineShop.wine.service.ShoppingCartService;

@Service
@Transactional
public class ApiShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository scRepository;
	
	@Override
	public ShoppingCart findOne(Long id) {
		return scRepository.findOne(id);
	}

	@Override
	public Page<ShoppingCart> findAll(int pageNum) {
		return scRepository.findAll(
				new PageRequest(pageNum, 5));
	}

	@Override
	public void save(ShoppingCart sc) {
		scRepository.save(sc);
		
	}

	@Override
	public void remove(Long id) {
		scRepository.delete(id);
		
	}

	@Override
	public Page<ShoppingCart> findByUserId(int pageNum, Long userId) {
		return scRepository.findByUserName(userId, new PageRequest(pageNum, 5));
	}

}
