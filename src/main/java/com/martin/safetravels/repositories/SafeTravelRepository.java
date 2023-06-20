package com.martin.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.martin.safetravels.models.SafeTravel;

@Repository
public interface SafeTravelRepository extends CrudRepository<SafeTravel,Long >{

	
	List<SafeTravel> findAll();
		
	
}
