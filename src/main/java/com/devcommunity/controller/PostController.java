package com.devcommunity.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcommunity.entity.Post;
import com.devcommunity.entity.PostVote;
import com.devcommunity.service.PostService;


@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService service;
	
//	Working
	@PostMapping("/")
	public Post addPost(@RequestBody Post p) {
		return service.addPost(p);
	}
	
//	Working
	@PutMapping("/")
	public Post updatePost(@RequestBody Post p) {
		return service.updatePost(p);
	}
	
//	Working
	@GetMapping("/")
	public List<Post> getAll(){
		return service.getAll();
	}
	
//	Working
	@GetMapping("/id")
	public Post getById(@RequestParam("id") Integer postId) {
		return service.getPostById(postId);
	}
	
//	Working
	@DeleteMapping("/id")
	public Post removeById(@RequestParam("id") Integer postId) {
		return service.removePost(postId);
	}
	
//	Working
	@GetMapping("/keyword")
	public List<Post> getByKeyword(@RequestParam("key") String keyword) {
		return service.getPostByKeyword(keyword);
	}
	
//	Working
	@GetMapping("/topic")
	public List<Post> getByTopic(@RequestParam("topic") String topic){
		return service.getPostByTopic(topic);
	}
	
//	Working
	@GetMapping("/date")
	public List<Post> getByDate(@RequestParam("date") String date){
		return service.getPostByDate(LocalDate.parse(date));
	}
	
	@GetMapping("/vote")
	public List<PostVote> getVotesOnPost(@RequestParam("id") Integer postId){
		return service.getVotesOnPostWithId(postId);
	}
	
}
