package com.devcommunity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.entity.Developer;
import com.devcommunity.repository.DeveloperRepository;
import com.devcommunity.repository.UserRepository;

@Service
public class DeveloperService {
	
	@Autowired
	UserRepository userrepo;

	@Autowired
	DeveloperRepository repository;
	
	public Developer addDeveloper(Developer d) {
		repository.save(d);
		return d;
	}
	
	public Developer updateDeveloper(Developer d) {
		Developer original = repository.findById(d.getUserId()).get();
		original = d;
		repository.save(original);
		return d;
	}
	
	public List<Developer> getAll(){
		return repository.findAll();
	}
	
	public List<Developer> getDeveloperByStatus(String status) {
	        
    	return repository.findAll().stream()
    			.filter(e -> e.getStatus().equals(status))
    			.collect(Collectors.toList());
	    	
	}
	
	public Developer getDeveloperById(Integer devId) {
        return repository.findById(devId).get();
    }
	
	public List<Developer> getDeveloperByReputation(Integer reputation) {
        return repository.findAll().stream()
        		.filter(e -> e.getReputation() >= reputation)
        		.collect(Collectors.toList());
    }
	
	public Developer getByMaxReputation() {
        return repository.findAll().stream()
        		.max((a,b) -> a.getReputation() - b.getReputation())
        		.get();
    }
	
}
