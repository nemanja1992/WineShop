package org.wineShop.wine.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wineShop.wine.model.Company;
import org.wineShop.wine.repository.CompanyRepository;
import org.wineShop.wine.service.CompanyService;

@Service
@Transactional
public class JpaCompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Page<Company> findAll(int pageNum) {
		return companyRepository.findAll(
				new PageRequest(pageNum, 8));
				
	}

	@Override
	public Company findOne(Long id) {
		return companyRepository.findOne(id);
	}

	@Override
	public void save(Company company) {
		companyRepository.save(company);
		
	}

	@Override
	public void remove(Long id) {
		companyRepository.delete(id);
		
	}



}
