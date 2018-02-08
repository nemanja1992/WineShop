package org.wineShop.wine.service;

import java.util.List;

import org.wineShop.wine.model.User;

public interface UserService {


	List<User> findAll();

	void delete(Long id);

	void save(User user);

	User findById(Long userId);
}	
