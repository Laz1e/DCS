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

import com.devcommunity.dto.ResponseCommentDTO;
import com.devcommunity.service.ResponseCommentService;

@RestController
@RequestMapping("/responsecomment")
public class ResponseCommentController {

	@Autowired
	ResponseCommentService service;
	
	@GetMapping("/")
	public List<ResponseCommentDTO> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/")
	public ResponseCommentDTO addComment(@RequestBody ResponseCommentDTO comment) {
		return service.addComment(comment);
	}
	
	@PutMapping("/")
	public ResponseCommentDTO updateComment(@RequestBody ResponseCommentDTO comment) {
		return service.updateComment(comment);
	}
	
	@DeleteMapping("/{id}")
	public ResponseCommentDTO removeComment(@PathVariable("id") Integer id) {
		return service.removeCommentFromResponse(id);
	}
	
	@GetMapping("/vote")
	public Integer getNoOfVotesOnCommentByVoteType(@RequestParam("type") String voteTpe,@RequestParam("id") Integer commentId) {
		return service.getNoOfVotesOnCommentByVoteType(voteTpe, commentId);
	}
	
	@GetMapping("/id")
	public ResponseCommentDTO getByCommentId(@RequestParam("id") Integer commentId) {
		return service.getByCommentId(commentId);
	}
	
	@GetMapping("/post")
	public List<ResponseCommentDTO> getCommentsByPostId(@RequestParam("id") Integer postId){
		return service.getCommentsByPostId(postId);
	}
	
}
