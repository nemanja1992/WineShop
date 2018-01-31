package org.wineShop.wine.service;



import org.springframework.data.domain.Page;

import org.wineShop.wine.model.Company;

public interface CompanyService {
	Page<Company> findAll(int pageNum);
	Company findOne(Long id);
	void save (Company company);
	void remove(Long id);

	
}
