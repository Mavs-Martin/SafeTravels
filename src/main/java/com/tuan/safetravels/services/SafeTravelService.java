package com.martin.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.safetravels.models.SafeTravel;
import com.martin.safetravels.repositories.SafeTravelRepository;

@Service
public class SafeTravelService {
	private final SafeTravelRepository safeRepo;

	public SafeTravelService(SafeTravelRepository safeRepo) {
		this.safeRepo = safeRepo;
	}
	//--------FIND ALL---------------------
	
	
	public List<SafeTravel> getAll(){
		return safeRepo.findAll();
	}
	
	//-------=-CREATE---------------------
	
	public SafeTravel create(SafeTravel SafeTravel) {
		return safeRepo.save(SafeTravel);
	}
	
	//-----------GET ONE---------------------
	
	public SafeTravel getOne(Long id) {
		Optional<SafeTravel> optionalSafeTravel = safeRepo.findById(id);
		if(optionalSafeTravel.isPresent()) {
			return optionalSafeTravel.get();
		}
		return null;
	}
	
	//--------------EDIT---------------------
	
	public SafeTravel update(SafeTravel SafeTravel) {
		return safeRepo.save(SafeTravel);
	}
	
	//------------DELETE------------
	
	public String delete(Long id) {
		safeRepo.deleteById(id);
		return id + " has been delted";
	}

}
