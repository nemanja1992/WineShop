package org.wineShop.wine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.wineShop.wine.model.Wine;

@Repository
public interface WineRepository
	extends JpaRepository<Wine, Long>{

	Page<Wine> findByCompanyId(Long companyId, Pageable pageRequest);
	Page<Wine> findByTypeId(Long TypeId, Pageable pageRequest);
	
	@Query("SELECT w FROM Wine w WHERE"
			+ "(:name IS NULL or w.name like :name)"
			)
	Page<Wine> find(
			@Param("name") String name,
			Pageable pageRequest);
	
	@Query("SELECT w FROM Wine w WHERE"
			+ "(:name IS NULL or w.name like :name) AND"
			+ "(:vintage IS NULL or w.vintage like :vintage) AND"
			+ "(:minPrice IS NULL or w.price > :minPrice) AND"
			+ "(:maxPrice IS NULL or w.price <= :maxPrice) "
			)
	Page<Wine> filter(
			@Param("name") String name,
			@Param("vintage") Integer vintage,
			@Param("minPrice") Double minPrice,
			@Param("maxPrice") Double maxPrice,
			Pageable pageRequest);
			
}
