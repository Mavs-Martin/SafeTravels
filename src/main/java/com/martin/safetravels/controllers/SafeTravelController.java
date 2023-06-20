package com.martin.safetravels.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martin.safetravels.models.SafeTravel;
import com.martin.safetravels.services.SafeTravelService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/safe")
public class SafeTravelController {

	public final SafeTravelService safeService;
	public SafeTravelController(SafeTravelService safeService) {
		this.safeService = safeService;
	}
	
	
	@GetMapping("")
	public String allTravels(Model model) {
		model.addAttribute("allTravels", safeService.getAll());
		model.addAttribute("safeTravel", new SafeTravel());
		return "safe/showAll.jsp";
	}
	
	@GetMapping("/{id}")
	public String oneTravel(@PathVariable("id") Long id, Model model) {
		model.addAttribute("SafeTravel", safeService.getOne(id));
		return"safe/displayOne.jsp";
	}
	
	
//	@GetMapping("/create")
//	public String createTravel(@ModelAttribute("safeTravel") SafeTravel safeTravel) {
//		return "safe/showAll.jsp";
//	}
	
	@PostMapping("/process/create")
	public String processCreateTravel(@Valid @ModelAttribute("safeTravel") SafeTravel safeTravel, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("allTravels", safeService.getAll());
			return "safe/showAll.jsp";
		}
		
		safeService.create(safeTravel);
		return "redirect:/safe";
	}
	
	@GetMapping("/edit/{id}")
	public String editTravel(@PathVariable("id") Long id, Model model) {
		model.addAttribute("safeTravel", safeService.getOne(id));
		return "safe/Edit.jsp";
	}
	
	
	@PutMapping("/process/edit/{id}")
	public String processEditTravel(@Valid @ModelAttribute("safeTravel") SafeTravel safeTravel, BindingResult result, @PathVariable("id") Long id) {
		
		if(result.hasErrors()) {
			return "donation/edit.jsp";
		}
		safeService.update(safeTravel);
		return "redirect:/safe/"+id;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTravel(@PathVariable("id") Long id) {
		safeService.delete(id);
		return "redirect:/safe";
	}
	
	
	

}
