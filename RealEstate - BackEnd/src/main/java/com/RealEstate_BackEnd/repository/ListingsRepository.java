package com.RealEstate_BackEnd.repository;


import com.RealEstate_BackEnd.model.Listing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingsRepository  extends JpaRepository<Listing, Long>{
	
			 
}
