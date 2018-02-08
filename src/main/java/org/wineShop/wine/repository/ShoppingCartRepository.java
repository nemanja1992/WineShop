package org.wineShop.wine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wineShop.wine.model.ShoppingCart;

@Repository						
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{
	
	Page<ShoppingCart> findByUserName(Long userId, Pageable pageRequest);
}
