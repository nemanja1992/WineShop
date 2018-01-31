package org.wineShop.wine.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wineShop.wine.model.Wine;
import org.wineShop.wine.service.WineService;
import org.wineShop.wine.support.WineDTOToWine;
import org.wineShop.wine.support.WineToWineDTO;
import org.wineShop.wine.web.dto.WineDTO;


@RestController
@RequestMapping("/api/wine")
public class ApiWineController {
	
	@Autowired 
	private WineService wineService;
	@Autowired
	private WineToWineDTO toDTO;
	@Autowired
	private WineDTOToWine toWine;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<WineDTO> get(
			@PathVariable Long id){
		Wine wine= wineService.findOne(id);
		
		if(wine == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(wine),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<WineDTO> add(
			@RequestBody WineDTO newWine){
		
		Wine wine = toWine.convert(newWine); 
		wineService.save(wine);
		
		return new ResponseEntity<>(toDTO.convert(wine),
				HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<WineDTO> edit(
			@PathVariable Long id,
			@RequestBody WineDTO edited){
		
		if(!id.equals(edited.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Wine wine = toWine.convert(edited); 
		wineService.save(wine);
		
		return new ResponseEntity<>(toDTO.convert(wine),
				HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<WineDTO> delete(@PathVariable Long id){
		wineService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
