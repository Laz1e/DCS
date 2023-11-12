package com.devcommunity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.DeveloperDTO;
import com.devcommunity.entity.Developer;
import com.devcommunity.entity.Post;
import com.devcommunity.repository.DeveloperRepository;


@Service
public class DeveloperService {

	@Autowired
	DeveloperRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	
	public DeveloperDTO addDeveloper(DeveloperDTO d) {
		repository.save(mapper.map(d, Developer.class));
		return d;
	}
	
	public DeveloperDTO updateDeveloper(DeveloperDTO d) {
		repository.save(mapper.map(d, Developer.class));
		return d;
	}
	
	public List<DeveloperDTO> getAll(){
		return repository.findAll().stream()
				.map(e -> mapper.map(e, DeveloperDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<DeveloperDTO> getDeveloperByStatus(String status) {
	        
    	return repository.findAll().stream()
    			.filter(e -> e.getStatus().equals(status))
    			.map(e -> mapper.map(e, DeveloperDTO.class))
    			.collect(Collectors.toList());
	    	
	}
	
	public DeveloperDTO getDeveloperById(Integer devId) {
        return mapper.map(repository.findById(devId).get(), DeveloperDTO.class);
    }
	
	public List<DeveloperDTO> getDeveloperByReputation(Integer reputation) {
        return repository.findAll().stream()
        		.filter(e -> e.getReputation() >= reputation)
        		.map(e -> mapper.map(e, DeveloperDTO.class))
        		.collect(Collectors.toList());
    }
	
	public DeveloperDTO getByMaxReputation() {
        return repository.findAll().stream()
        		.max((a,b) -> a.getReputation() - b.getReputation())
        		.map(e -> mapper.map(e, DeveloperDTO.class))
        		.get();
    }
	
//	public List<Post> getPostsByDeveloper(Integer devId){
//		return repository.findById(devId).get()
//				.getListOfPosts();
//	}
	
//	public List<DeveloperDTO> getByNoOfPosts(Integer noOfPosts){
//		return repository.findAll().stream()
//				.filter(e -> e.getListOfPosts().size() == noOfPosts)
//				.map(e -> mapper.map(e, DeveloperDTO.class))
//				.collect(Collectors.toList());
//	}
	
}
