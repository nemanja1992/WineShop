package org.wineShop.wine.service;



import java.util.List;


import org.wineShop.wine.model.Company;

public interface CompanyService {
	List<Company> findAll();
	Company findOne(Long id);
	void save (Company company);
	void remove(Long id);

	
}
