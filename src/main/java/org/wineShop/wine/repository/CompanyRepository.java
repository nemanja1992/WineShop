package org.wineShop.wine.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wineShop.wine.model.Company;


@Repository
public interface CompanyRepository 
	extends JpaRepository<Company,Long>{

	

}
