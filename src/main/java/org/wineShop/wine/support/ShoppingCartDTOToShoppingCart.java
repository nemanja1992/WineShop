package org.wineShop.wine.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.wineShop.wine.model.ShoppingCart;
import org.wineShop.wine.service.ShoppingCartService;
import org.wineShop.wine.service.UserService;
import org.wineShop.wine.service.WineService;
import org.wineShop.wine.web.dto.ShoppingCartDTO;

@Component
public class ShoppingCartDTOToShoppingCart implements Converter<ShoppingCartDTO, ShoppingCart>{
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private WineService wineService;
	@Autowired
	private UserService userService;
	
	@Override
	public ShoppingCart convert(ShoppingCartDTO source) {
		ShoppingCart sc;
		if(source.getId()==null){
			sc= new ShoppingCart();
			sc.setUser(userService.findById(source.getUserId()));
			sc.setWine(wineService.findOne(source.getWineId()));
		}else{
			sc=shoppingCartService.findOne(source.getId());
		}
		sc.setAmount(source.getAmount());
		sc.setStock(source.getStock());
		sc.setStatus(source.getStatus());
		sc.setDate(source.getDate());
		return sc;
	}
	
	

}
