package com.devcommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcommunity.dto.DeveloperDTO;
import com.devcommunity.service.DeveloperService;

@RestController
@RequestMapping("/dev")
public class DeveloperController {

	@Autowired
	DeveloperService service;
	
//	Working
	@PostMapping("/")
	public DeveloperDTO addDev(@RequestBody DeveloperDTO d) {
		return service.addDeveloper(d);
	}
	
//	Working
	@PutMapping("/")
	public DeveloperDTO updateDev(@RequestBody DeveloperDTO d) {
//		System.out.println(d);
		return service.updateDeveloper(d);
	}
	
//	Working
	@GetMapping("/")
	public List<DeveloperDTO> getAll(){
		return service.getAll();
	}
	
//	Working
	@GetMapping("/status")
	public List<DeveloperDTO> getByStatus(@RequestParam("status") String status){
		return service.getDeveloperByStatus(status);
	}
	
//	Working
	@GetMapping("/id")
	public DeveloperDTO getById(@RequestParam("id") Integer devId) {
		return service.getDeveloperById(devId);
	}
	
//	Working
	@GetMapping("/rep")
	public List<DeveloperDTO> getByReputation(@RequestParam("rep") Integer reputation){
		return service.getDeveloperByReputation(reputation);
	}
	
//	Working
	@GetMapping("/max")
	public DeveloperDTO getByMaxReputation() {
		return service.getByMaxReputation();
	}
	
//	Not Working
//	Gives error "com.fasterxml.jackson.databind" json error
	
	/*	Working
	 * Solved Using this property 
	 * @JsonIgnoreProperties({"hibernateLazyInitializer","handler","listOfResponse"})
	 * 
	 */
	
	/*
	 * // @GetMapping("/posts") // public List<Post>
	 * getPostsByDeveloper(@RequestParam("id") Integer devId){ // return
	 * service.getPostsByDeveloper(devId); // }
	 */	
	/*
	 * // Working
	 * 
	 * @GetMapping("/total") public List<Developer>
	 * getByNoOfPosts(@RequestParam("posts") Integer noOfPosts){ return
	 * service.getByNoOfPosts(noOfPosts); }
	 */
	
}
