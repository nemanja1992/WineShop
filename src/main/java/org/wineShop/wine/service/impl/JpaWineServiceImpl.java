package org.wineShop.wine.service.impl;


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
	public Page<Wine> findAll(int pageNum) {
		return wineRepository.findAll(
				new PageRequest(pageNum, 8));
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

	@Override
	public Page<Wine> find(String name, int page) {
		if(name != null ){
			name = "%" + name + "%";
		}
		
		if(name != null ){
			name = "%" + name + "%";
		}
		return wineRepository.find(name,   new PageRequest(page, 8));
	}



}
