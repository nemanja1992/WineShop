package org.wineShop.wine.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wineShop.wine.model.Wine;
import org.wineShop.wine.service.CompanyService;
import org.wineShop.wine.service.WineService;
import org.wineShop.wine.web.dto.WineDTO;


@Component
public class WineDTOToWine 
	implements Converter<WineDTO, Wine>{

	@Autowired
	private WineService wineService;
	@Autowired
	private CompanyService companyService;
	
	@Override
	public Wine convert(WineDTO source) {
		Wine wine;
		if(source.getId()==null){
			wine=new Wine();
			wine.setCompany(
					companyService.findOne(
							source.getCompanyId()));
		}else{
			wine=wineService.findOne(source.getId());
		}
		wine.setName(source.getName());
		wine.setAlcoholPercent(source.getAlcoholPercent());
		wine.setVintage(source.getVintage());
		wine.setPrice(source.getPrice());
		wine.setQuantity(source.getQuantity());
		
		return wine;
	}
	
}
