package com.devcommunity.controller;

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

import com.devcommunity.entity.Response;
import com.devcommunity.service.ResponseService;

@RestController
@RequestMapping("/response")
public class ResponseController {

	@Autowired
	ResponseService service;
	
//	Working
	@PostMapping("/")
	public Response addResponse(@RequestBody Response r) {
		return service.addResponse(r);
	}
	
//	Working
	@PutMapping("/")
	public Response updateResponse(@RequestBody Response r) {
		return service.updateResponse(r);
	}
	
	/*
	 * 	Not Working
	 * 
	 * 	Deletes the data from database but shows following error
	 * 	
	 * 	com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer
	 * found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and
	 * no properties discovered to create BeanSerializer (to avoid exception,
	 * disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain:
	 * com.devcommunity.entity.Response["post"]->
	 * com.devcommunity.entity.Post$HibernateProxy$cmf9YRjt[
	 * "hibernateLazyInitializer"])
	 */
	
	/*
	 * 	Working
	 * Solved Using this property 
	 * @JsonIgnoreProperties({"hibernateLazyInitializer","handler","listOfResponse"})
	 * 
	 */
	
	@DeleteMapping("/id")
	public Response removeResponse(@RequestParam("id") Integer respId) {
		return service.removeResponse(respId);
	}
	
	/*
	 * Not Working
	 * Following error is shown
	 * at
	 * com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.
	 * java:178) ~[jackson-databind-2.13.5.jar:2.13.5]
	 * 
	 */
	
	/*	Working
	 * Solved Using this property 
	 * @JsonIgnoreProperties({"hibernateLazyInitializer","handler","listOfResponse"})
	 * 
	 */
	
	@GetMapping("/post")
	public List<Response> getResponseByPost(@RequestParam("id") Integer postId){
		return service.getResponseByPost(postId);
	}

	/*
	 * Working 
	 * due to 
	 * @JsonIgnoreProperties({"hibernateLazyInitializer","handler","listOfResponse"})
	 */	
	@GetMapping("/dev")
	public List<Response> getResponseByDeveloper(@RequestParam("id") Integer devId){
		return service.getResponseByDeveloper(devId);
	}
	
	
}
