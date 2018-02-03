package org.wineShop.wine.web.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wineShop.wine.model.Type;
import org.wineShop.wine.model.Wine;
import org.wineShop.wine.service.TypeService;
import org.wineShop.wine.service.WineService;
import org.wineShop.wine.support.TypeToTypeDTO;
import org.wineShop.wine.support.WineToWineDTO;
import org.wineShop.wine.web.dto.TypeDTO;
import org.wineShop.wine.web.dto.WineDTO;



@RestController
@RequestMapping("/api/type")
public class ApiTypeController {
	@Autowired
	private TypeService typeService;
	@Autowired
	private WineService wineService;
	@Autowired
	private TypeToTypeDTO toDTO;
	@Autowired
	private WineToWineDTO toWineDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TypeDTO>> get(){
		return new ResponseEntity<>(
				toDTO.convert(typeService.findAll()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TypeDTO> get(
			@PathVariable Long id){
		Type type= typeService.findOne(id);
		if(type== null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<> (
				toDTO.convert(type),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{typeId}/wines")
	public ResponseEntity<List<WineDTO>> wineType(
			@PathVariable Long typeId,
			@RequestParam(defaultValue="0") int pageNum){
		Page<Wine> wines= wineService.findByTypeId(pageNum, typeId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(wines.getTotalPages()));
		return new ResponseEntity<>(
				toWineDTO.convert(wines.getContent()),
				headers,
				HttpStatus.OK);
	}
}
