package com.project.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.services.PostService;
import com.project.blog.util.PostDto;

@RestController
@RequestMapping("post")
public class PostController {
	
	@Autowired
	private PostService ps;
	
	@PostMapping("addPost/user/{userId}/category/{categoryId}")
	private ResponseEntity<PostDto> show(@RequestBody PostDto p,@PathVariable int userId,@PathVariable int categoryId){
		PostDto pd=ps.addPost(p, userId, categoryId);
		return new ResponseEntity<PostDto>(pd,HttpStatus.CREATED);
	}

}
