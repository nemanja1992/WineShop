package org.wineShop.wine.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.wineShop.wine.model.Wine;

public interface WineService {
	Wine findOne(Long id);
	List<Wine> findAll();
	void save (Wine wine);
	void remove (Long id);
	Page<Wine> findByCompanyId(int pageNum, Long companyId);
	Page<Wine> findByTypeId(int pageNum, Long typeId);
}
