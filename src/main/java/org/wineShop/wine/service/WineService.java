package org.wineShop.wine.service;



import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.wineShop.wine.model.Wine;

public interface WineService {
	Wine findOne(Long id);
	Page<Wine> findAll(int pageNum);
	void save (Wine wine);
	void remove (Long id);
	Page<Wine> findByCompanyId(int pageNum, Long companyId);
	Page<Wine> findByTypeId(int pageNum, Long typeId);
	Page<Wine> find(
			@Param("name") String name,
			int page);
	Page<Wine> filter(
			@Param("name") String name,
			@Param("vintage") Integer vintage,
			@Param("minPrice") Double minPrice,
			@Param("maxPrice") Double maxPrice,
			int page);
}
