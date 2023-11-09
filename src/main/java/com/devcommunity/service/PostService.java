package com.devcommunity.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcommunity.entity.Post;
import com.devcommunity.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;
	
	public Post addPost(Post p) {
		repository.save(p);	
		return p;
	}
	
	public Post updatePost(Post p) {
		repository.save(p);
		return p;
	}
	
	public List<Post> getAll(){
		return repository.findAll();
	}
	
	public Post getPostById(Integer postId) {
		Post p = repository.findById(postId).get();
//		Integer devId = p.getDeveloper().getUserId();
//		System.out.println(devId);
		return p;
	}
	
	public Post removePost(Integer postId) {
		Post p = repository.findById(postId).get();
		repository.delete(p);
		return p;
	}
	
	public List<Post> getPostByKeyword(String keyword){
		return repository.findAll().stream()
				.filter(e -> e.getQuery().contains(keyword))
				.collect(Collectors.toList());
	}
	
	public List<Post> getPostByTopic(String topic){
		return repository.findAll().stream()
				.filter(e -> e.getTopic().equals(topic))
				.collect(Collectors.toList());
	}
	
	public List<Post> getPostByDate(LocalDate date){
		return repository.findAll().stream()
				.filter(e -> e.getPostDateTime().equals(date))
				.collect(Collectors.toList());
	}

}
