package com.devcommunity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.ResponseCommentDTO;
import com.devcommunity.entity.ResponseComment;
import com.devcommunity.repository.ResponseCommentRepository;
import com.devcommunity.repository.ResponseRepository;

@Service
public class ResponseCommentService {
	
	@Autowired
	ResponseCommentRepository repository;
	
	@Autowired
	ResponseRepository resprepo;
	
	ModelMapper mapper = new ModelMapper();
	
	public ResponseCommentDTO addComment(ResponseCommentDTO comment) {
		repository.save(mapper.map(comment, ResponseComment.class));
		return comment;
	}
	
	public ResponseCommentDTO updateComment(ResponseCommentDTO comment) {
		repository.save(mapper.map(comment, ResponseComment.class));
		return comment;
	}
	
	public ResponseCommentDTO removeCommentFromResponse(Integer id) {
		
		ResponseComment p = repository.findById(id).get();
		repository.delete(p);
		return mapper.map(p, ResponseCommentDTO.class);
		
	}
	
	public Integer getNoOfVotesOnCommentByVoteType(String voteType,Integer commentId){
		return (int)repository.findAll().stream()
				.filter(e -> e.getVote().getVoteType().toString().equals(voteType))
				.count();
	}
	
	public ResponseCommentDTO getByCommentId(Integer commentId) {
		return mapper.map(repository.findById(commentId).get(), ResponseCommentDTO.class); 
	}
	
	public List<ResponseCommentDTO> getAll(){
		return repository.findAll().stream()
				.map(e -> mapper.map(e, ResponseCommentDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<ResponseCommentDTO> getCommentsByPostId(Integer postId){
		return resprepo.findById(postId).get().getListOfComments()
				.stream()
				.map(e -> mapper.map(e, ResponseCommentDTO.class))
				.collect(Collectors.toList());
	}


}
