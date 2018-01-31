package org.wineShop.wine.web.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wineShop.wine.model.Company;
import org.wineShop.wine.model.Wine;
import org.wineShop.wine.service.CompanyService;
import org.wineShop.wine.service.WineService;
import org.wineShop.wine.support.CompanyToCompanyDTO;
import org.wineShop.wine.support.WineToWineDTO;
import org.wineShop.wine.web.dto.CompanyDTO;
import org.wineShop.wine.web.dto.WineDTO;


@RestController
@RequestMapping("/api/company")
public class ApiCompanyController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private WineService wineService;
	@Autowired
	private CompanyToCompanyDTO toDTO;
	@Autowired
	private WineToWineDTO toWineDTO;
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CompanyDTO> get(
			@PathVariable Long id){
		Company company=companyService.findOne(id);
		
		if(company==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(company),
				HttpStatus.OK);
	}
	

	@RequestMapping(value="/{companyId}/wines")
	public ResponseEntity<List<WineDTO>> wineCompany(
		@PathVariable Long companyId,
		@RequestParam(defaultValue="0") int pageNum){
			Page<Wine> wines =wineService.findByCompanyId(pageNum, companyId);
			
			HttpHeaders headers=new HttpHeaders();
			headers.add("totalPages", Integer.toString(wines.getTotalPages()));
			return new ResponseEntity<>(
					toWineDTO.convert(wines.getContent()),
					headers,
					HttpStatus.OK);
		
	}
	

		
	
}
