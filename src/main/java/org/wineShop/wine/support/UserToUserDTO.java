package org.wineShop.wine.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wineShop.wine.model.User;
import org.wineShop.wine.web.dto.UserDTO;
@Component
public class UserToUserDTO 
	implements Converter<User,UserDTO>{

	@Override
	public UserDTO convert(User u) {
		UserDTO dto= new UserDTO();
		dto.setId(u.getId());
		dto.setName(u.getName());
		dto.setEmail(u.getEmail());
		dto.setPassword(u.getPassword());
		return dto;
	}
	
	public List<UserDTO> convert (List<User> user){
		List<UserDTO> ret= new ArrayList<>();
		
		for(User u: user){
			ret.add(convert(u));
		}
		return ret;
	}
	
	
	
	

}
