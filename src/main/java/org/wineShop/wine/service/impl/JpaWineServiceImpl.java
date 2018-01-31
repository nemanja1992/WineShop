package org.wineShop.wine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wineShop.wine.model.Wine;
import org.wineShop.wine.repository.WineRepository;
import org.wineShop.wine.service.WineService;


@Service
@Transactional
public class JpaWineServiceImpl implements WineService {

	
	@Autowired
	private WineRepository wineRepository;
	
	@Override
	public List<Wine> findAll() {
		return wineRepository.findAll();
	}

	@Override
	public void save(Wine wine) {
		wineRepository.save(wine);
		
	}

	@Override
	public void remove(Long id) {
		wineRepository.delete(id);
		
	}

	@Override
	public Wine findOne(Long id) {
		return wineRepository.findOne(id);
	}

	@Override
	public Page<Wine> findByCompanyId(int pageNum, Long companyId) {
		
		return wineRepository.findByCompanyId(companyId, new PageRequest(pageNum, 10));
	}

	@Override
	public Page<Wine> findByTypeId(int pageNum, Long typeId) {
		
		return wineRepository.findByTypeId(typeId, new PageRequest(pageNum, 10));
	}



}
