package com.devcommunity.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcommunity.entity.Developer;
import com.devcommunity.service.DeveloperService;

@RestController
@RequestMapping("/dev")
public class DeveloperController {

	@Autowired
	DeveloperService service;
	
	@PostMapping("/")
	public Developer addDev(@RequestBody Developer d) {
		return service.addDeveloper(d);
	}
	
	@PutMapping("/")
	public Developer updateDev(@RequestBody Developer d) {
		System.out.println(d);
		return service.updateDeveloper(d);
	}
	
	@GetMapping("/")
	public List<Developer> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/status")
	public List<Developer> getByStatus(@RequestParam("status") String status){
		return service.getDeveloperByStatus(status);
	}
	
	@GetMapping("/id")
	public Developer getById(@RequestParam("id") Integer devId) {
		return service.getDeveloperById(devId);
	}
	
	@GetMapping("/rep")
	public List<Developer> getByReputation(@RequestParam("rep") Integer reputation){
		return service.getDeveloperByReputation(reputation);
	}
	
	@GetMapping("/max")
	public Developer getByMaxReputation() {
		return service.getByMaxReputation();
	}
	
}
