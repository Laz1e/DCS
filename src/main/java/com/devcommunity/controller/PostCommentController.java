package com.devcommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcommunity.dto.PostCommentDTO;
import com.devcommunity.service.PostCommentService;

@RestController
@RequestMapping("/postcomment")
public class PostCommentController {
	
	@Autowired
	PostCommentService service;
	
	@GetMapping("/")
	public List<PostCommentDTO> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/")
	public PostCommentDTO addComment(@RequestBody PostCommentDTO comment) {
		return service.addComment(comment);
	}
	
	@PutMapping("/")
	public PostCommentDTO updateComment(@RequestBody PostCommentDTO comment) {
		return service.updateComment(comment);
	}
	
	@DeleteMapping("/{id}")
	public PostCommentDTO removeComment(@PathVariable("id") Integer id) {
		return service.removeCommentFromPost(id);
	}
	
	@GetMapping("/vote")
	public Integer getNoOfVotesOnCommentByVoteType(@RequestParam("type") String voteTpe,@RequestParam("id") Integer commentId) {
		return service.getNoOfVotesOnCommentByVoteType(voteTpe, commentId);
	}
	
	@GetMapping("/id")
	public PostCommentDTO getByCommentId(@RequestParam("id") Integer commentId) {
		return service.getByCommentId(commentId);
	}
	
	@GetMapping("/post")
	public List<PostCommentDTO> getCommentsByPostId(@RequestParam("id") Integer postId){
		return service.getCommentsByPostId(postId);
	}

}
