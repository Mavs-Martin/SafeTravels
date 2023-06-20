package com.martin.safetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.martin.safetravels.models.SafeTravel;
import com.martin.safetravels.services.SafeTravelService;

@RestController
@RequestMapping("/api")
public class ApiController {

	private final SafeTravelService safeRepo;
	public ApiController(SafeTravelService safeRepo) {
		this.safeRepo = safeRepo; 
	}
	
	//--------FIND ALL---------------------
	
	@GetMapping("/safe")
	public List<SafeTravel> FindAllTravel(){
		return safeRepo.getAll();
	}
	
	//------------Creating-------------
	
	@PostMapping("/safe")
	public SafeTravel createSafeTravel(@RequestParam("name") String name, @RequestParam("vendor") String vendor, @RequestParam("amount") Integer amount, @RequestParam("descripton") String descripton) {
		SafeTravel newSafeTravel = new SafeTravel(name, vendor, amount, descripton );
		return safeRepo.create(newSafeTravel);
	}
	
	// Find One -----------(/safe/{id}--------
	
	@GetMapping("/safe/{id}")
	public SafeTravel findOneSafeTravel(@PathVariable("id") Long id) {
		return safeRepo.getOne(id);
	}
	
	
	// EDIT---------(/safe/{id}----------
	
	@PutMapping("/safe/{id}")
	public SafeTravel editOneSafeTravel(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("vendor") String vendor, @RequestParam("amount") Integer amount, @RequestParam("descripton") String descripton) {
		
		SafeTravel SafeTravelToBeUpdated = new SafeTravel(name, vendor, amount, descripton);
		SafeTravelToBeUpdated.setId(id);
		return safeRepo.update(SafeTravelToBeUpdated);
	}
	
	
	// DELETE-----------(/safe/{id}-------
	
	@DeleteMapping("/safe/{id}")
	public String DeleteSafeTravel(@PathVariable("id") Long id) {
		return safeRepo.delete(id);
	}
	
	

}
