package org.wineShop.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wineShop.wine.model.Type;

@Repository
public interface TypeRepository 
	extends JpaRepository<Type, Long>{

}
