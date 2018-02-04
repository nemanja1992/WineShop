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
			
}
