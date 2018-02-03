package org.wineShop.wine.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wineShop.wine.model.Type;
import org.wineShop.wine.web.dto.TypeDTO;

@Component
public class TypeToTypeDTO 
	implements Converter<Type, TypeDTO>{

	@Override
	public TypeDTO convert(Type c) {
		TypeDTO dto=new TypeDTO();
		dto.setId(c.getId());
		dto.setName(c.getName());
		return dto;
	}
	
	public List<TypeDTO> convert(List<Type> type){
		List<TypeDTO> ret=new ArrayList<>();
		
		for(Type c: type){
			ret.add(convert(c));
		}
		return ret;
	}

}
