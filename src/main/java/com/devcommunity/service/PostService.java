package com.devcommunity.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.dto.PostDTO;
import com.devcommunity.entity.Post;
import com.devcommunity.entity.PostVote;
//import com.devcommunity.entity.Vote;
import com.devcommunity.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	public PostDTO addPost(PostDTO p) {
		repository.save(mapper.map(p, Post.class));	
		return p;
	}
	
	public PostDTO updatePost(PostDTO p) {
		repository.save(mapper.map(p, Post.class));	
		return p;
	}
	
	public List<PostDTO> getAll(){
		return repository.findAll().stream()
				.map(e -> mapper.map(e, PostDTO.class))
				.collect(Collectors.toList());
	}
	
	public PostDTO getPostById(Integer postId) {
		return mapper.map(repository.findById(postId).get(),PostDTO.class);
	}
	
	public PostDTO removePost(Integer postId) {
		Post p = repository.findById(postId).get();
		repository.delete(p);
		return mapper.map(p, PostDTO.class);
	}
	
	public List<PostDTO> getPostByKeyword(String keyword){
		return repository.findAll().stream()
				.filter(e -> e.getQuery().contains(keyword))
				.map(e -> mapper.map(e, PostDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<PostDTO> getPostByTopic(String topic){
		return repository.findAll().stream()
				.filter(e -> e.getTopic().equals(topic))
				.map(e -> mapper.map(e, PostDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<PostDTO> getPostByDate(LocalDate date){
		return repository.findAll().stream()
				.filter(e -> e.getPostDateTime().equals(date))
				.map(e -> mapper.map(e, PostDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<PostVote> getVotesOnPostWithId(Integer postId){
		return repository.findById(postId).get().getVote();
	}

}
