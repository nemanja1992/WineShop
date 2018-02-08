package org.wineShop.wine.service;

import org.springframework.data.domain.Page;
import org.wineShop.wine.model.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart findOne(Long id);
	Page<ShoppingCart> findAll(int PageNum);
	void save (ShoppingCart sc);
	void remove (Long id);
	Page<ShoppingCart> findByUserId(int pageNum, Long userId);
}
