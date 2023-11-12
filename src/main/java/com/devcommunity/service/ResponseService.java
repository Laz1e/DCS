package com.devcommunity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.ResponseDTO;
import com.devcommunity.entity.Response;
import com.devcommunity.repository.ResponseRepository;

@Service
public class ResponseService {

	@Autowired
	ResponseRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	public ResponseDTO addResponse(ResponseDTO response) {
		repository.save(mapper.map(response, Response.class));
		return response;
	}
	
	public ResponseDTO updateResponse(ResponseDTO response) {
		repository.save(mapper.map(response, Response.class));
		return response;
	}
	
	public ResponseDTO removeResponse(Integer respId) {
		Response r = repository.findById(respId).get();
		repository.delete(r);
		return mapper.map(r, ResponseDTO.class);
	}
	
	public List<ResponseDTO> getResponseByPost(Integer postId){
		return repository.findAll().stream()
				.filter(e -> e.getPost().getPostId() == postId)
				.map(e -> mapper.map(e, ResponseDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<ResponseDTO> getResponseByDeveloper(Integer devId){
		return repository.findAll().stream()
				.filter(e -> e.getDeveloper().getUserId() == devId)
				.map(e -> mapper.map(e, ResponseDTO.class))
				.collect(Collectors.toList());
	}
	
	public Integer getNoOfVotesOnResponseByVoteType(String  voteType, Integer resId) {
		return (int)repository.findById(resId).get().getVote().stream().count();
	}
	
}
