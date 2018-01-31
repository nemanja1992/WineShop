package org.wineShop.wine.support;



import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wineShop.wine.model.Company;
import org.wineShop.wine.web.dto.CompanyDTO;


@Component
public class CompanyToCompanyDTO 
	implements Converter<Company, CompanyDTO>{

	@Override
	public CompanyDTO convert(Company n) {
		CompanyDTO dto=new CompanyDTO();
		dto.setId(n.getId());
		dto.setName(n.getName());
		dto.setPib(n.getPib());
		dto.setCountry(n.getCountry());

		
		return dto;
	}
	
	public List<CompanyDTO> convert(List<Company> company){
		List<CompanyDTO> ret= new ArrayList<>();
		
		for(Company n: company){
			ret.add(convert(n));
		}
		return ret;
	}

}
