package com.devcommunity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.entity.Response;
import com.devcommunity.repository.ResponseRepository;

@Service
public class ResponseService {

	@Autowired
	ResponseRepository repository;
	
	public Response addResponse(Response response) {
		repository.save(response);
		return response;
	}
	
	public Response updateResponse(Response response) {
		repository.save(response);
		return response;
	}
	
	public Response removeResponse(Integer respId) {
		Response r = repository.findById(respId).get();
		repository.delete(r);
		return r;
	}
	
	public List<Response> getResponseByPost(Integer postId){
		return repository.findAll().stream()
				.filter(e -> e.getPost().getPostId() == postId)
				.collect(Collectors.toList());
	}
	
	public List<Response> getResponseByDeveloper(Integer devId){
		return repository.findAll().stream()
				.filter(e -> e.getDeveloper().getUserId() == devId)
				.collect(Collectors.toList());
	}
	
}
