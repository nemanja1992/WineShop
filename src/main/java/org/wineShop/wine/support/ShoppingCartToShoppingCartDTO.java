package org.wineShop.wine.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wineShop.wine.model.ShoppingCart;
import org.wineShop.wine.web.dto.ShoppingCartDTO;

@Component	
public class ShoppingCartToShoppingCartDTO implements Converter<ShoppingCart, ShoppingCartDTO>{

	@Override
	public ShoppingCartDTO convert(ShoppingCart sc) {
		ShoppingCartDTO dto= new ShoppingCartDTO();
		dto.setId(sc.getId());
		dto.setStock(sc.getStock());
		dto.setAmount(sc.getAmount());
		dto.setStatus(sc.getStatus());
		dto.setDate(sc.getDate());
		dto.setUserId(sc.getUser().getId());
		dto.setUserName(sc.getUser().getName());
		dto.setUserEmail(sc.getUser().getEmail());
		dto.setUserPassword(sc.getUser().getPassword());
		dto.setWineId(sc.getWine().getId());
		dto.setWineName(sc.getWine().getName());
		dto.setWineQuantity(sc.getWine().getQuantity());
		dto.setWinePrice(sc.getWine().getPrice());
		return dto;
	}
	
	public List<ShoppingCartDTO> convert(List<ShoppingCart> shoppingCart){
		List<ShoppingCartDTO> ret = new ArrayList<>();
		
		for(ShoppingCart sc: shoppingCart){
			ret.add(convert(sc));
		}
		return ret;
	}
	
}
