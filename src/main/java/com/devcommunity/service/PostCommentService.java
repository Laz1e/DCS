package com.devcommunity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.PostCommentDTO;
import com.devcommunity.entity.PostComment;
import com.devcommunity.repository.PostCommentRepository;
import com.devcommunity.repository.PostRepository;

@Service
public class PostCommentService {
	
	@Autowired
	PostCommentRepository repository;
	
	@Autowired
	PostRepository postrepo;
	
	ModelMapper mapper = new ModelMapper();
	
	public PostCommentDTO addComment(PostCommentDTO comment) {
		repository.save(mapper.map(comment, PostComment.class));
		return comment;
	}
	
	public PostCommentDTO updateComment(PostCommentDTO comment) {
		repository.save(mapper.map(comment, PostComment.class));
		return comment;
	}
	
	public PostCommentDTO removeCommentFromPost(Integer id) {
		
		PostComment p = repository.findById(id).get();
		repository.delete(p);
		return mapper.map(p, PostCommentDTO.class);
		
	}
	
	public Integer getNoOfVotesOnCommentByVoteType(String voteType,Integer commentId){
		return (int)repository.findAll().stream()
				.filter(e -> e.getVote().getVoteType().toString().equals(voteType))
				.count();
	}
	
	public PostCommentDTO getByCommentId(Integer commentId) {
		return mapper.map(repository.findById(commentId).get(), PostCommentDTO.class); 
	}
	
	public List<PostCommentDTO> getAll(){
		return repository.findAll().stream()
				.map(e -> mapper.map(e, PostCommentDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<PostCommentDTO> getCommentsByPostId(Integer postId){
		return postrepo.findById(postId).get().getListOfComments()
				.stream()
				.map(e -> mapper.map(e, PostCommentDTO.class))
				.collect(Collectors.toList());
	}

}
