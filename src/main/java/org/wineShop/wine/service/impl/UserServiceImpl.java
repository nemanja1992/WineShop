package org.wineShop.wine.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wineShop.wine.model.User;
import org.wineShop.wine.repository.UserRepository;
import org.wineShop.wine.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	


	

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
		
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}





	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
