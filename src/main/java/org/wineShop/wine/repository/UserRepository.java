package org.wineShop.wine.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wineShop.wine.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
