package org.wineShop.wine.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wineShop.wine.model.User;
import org.wineShop.wine.service.UserService;
import org.wineShop.wine.support.UserToUserDTO;
import org.wineShop.wine.web.dto.UserDTO;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserToUserDTO toDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> get(){
		return new ResponseEntity<>(
				toDTO.convert(userService.findAll()),
				HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> get(
			@PathVariable Long id){
		User user = userService.findById(id);
		if(user== null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				toDTO.convert(user),
				HttpStatus.OK);
		
	}
	
}
