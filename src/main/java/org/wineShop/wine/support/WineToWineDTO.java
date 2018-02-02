package org.wineShop.wine.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wineShop.wine.model.Wine;
import org.wineShop.wine.web.dto.WineDTO;

@Component
public class WineToWineDTO 
	implements Converter<Wine, WineDTO>{

	@Override
	public WineDTO convert(Wine c) {
		WineDTO dto=new WineDTO();
		dto.setId(c.getId());
		dto.setName(c.getName());
		dto.setAlcoholPercent(c.getAlcoholPercent());
		dto.setPrice(c.getPrice());
		dto.setQuantity(c.getQuantity());
		dto.setVintage(c.getVintage());
		dto.setCompanyId(c.getCompany().getId());
		dto.setCompanyName(c.getCompany().getName());
		dto.setCompanyPib(c.getCompany().getPib());
		dto.setCompanyCountry(c.getCompany().getCountry());
		dto.setTypeId(c.getType().getId());
		dto.setTypeName(c.getType().getName());
		
		
		return dto;
	}
	
	public List<WineDTO> convert(List<Wine> wine){
		List<WineDTO> ret= new ArrayList<>();
		
		for(Wine c: wine){
			ret.add(convert(c));
		}
		
		return ret;
	}
	

	
}
