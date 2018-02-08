package org.wineShop.wine.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wineShop.wine.model.ShoppingCart;
import org.wineShop.wine.service.ShoppingCartService;
import org.wineShop.wine.support.ShoppingCartDTOToShoppingCart;
import org.wineShop.wine.support.ShoppingCartToShoppingCartDTO;
import org.wineShop.wine.web.dto.ShoppingCartDTO;


@RestController
@RequestMapping("/api/shoppingCart")
public class ApiShoppingCartController {

		@Autowired
		private ShoppingCartService scService;
		@Autowired
		private ShoppingCartToShoppingCartDTO toDTO;
		@Autowired
		private ShoppingCartDTOToShoppingCart toSC;
		
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<ShoppingCartDTO>> get(
				@RequestParam(defaultValue="0") int pageNum	){
			
			Page<ShoppingCart> sc;

				sc=scService.findAll(pageNum);
			
			
			HttpHeaders headers= new HttpHeaders();
			headers.add("totalPages", Integer.toString(sc.getTotalPages()));
			return new ResponseEntity<>(
					toDTO.convert(sc.getContent()),
					headers,
					HttpStatus.OK);
		}

		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<ShoppingCartDTO> get(
				@PathVariable Long id){
			ShoppingCart sc= scService.findOne(id);

			if(sc == null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(
					toDTO.convert(sc),
					HttpStatus.OK);
		}

		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<ShoppingCartDTO> add(
				@RequestBody ShoppingCartDTO newSCard){

			ShoppingCart	sc = toSC.convert(newSCard); 
			scService.save(sc);

			return new ResponseEntity<>(toDTO.convert(sc),
					HttpStatus.CREATED);
		}

		@RequestMapping(method=RequestMethod.PUT,
				value="/{id}")
		public ResponseEntity<ShoppingCartDTO> edit(
				@PathVariable Long id,
				@RequestBody ShoppingCartDTO edited){

			if(!id.equals(edited.getId())){
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			ShoppingCart sc = toSC.convert(edited); 
			scService.save(sc);

			return new ResponseEntity<>(toDTO.convert(sc),
					HttpStatus.OK);
		}
		@RequestMapping(method=RequestMethod.DELETE,
				value="/{id}")
		public ResponseEntity<ShoppingCartDTO> delete(@PathVariable Long id){
			scService.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
}
