package com.project.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.payload.PageResponse;
import com.project.blog.payload.apiResponse;
import com.project.blog.services.PostService;
import com.project.blog.util.PostDto;

@RestController
@RequestMapping("post")
public class PostController {
	
	@Autowired
	private PostService ps;
	
	@PostMapping("addPost/user/{userId}/category/{categoryId}")
	private ResponseEntity<PostDto> save(@RequestBody PostDto p,@PathVariable int userId,@PathVariable int categoryId){
		PostDto pd=ps.addPost(p, userId, categoryId);
		return new ResponseEntity<PostDto>(pd,HttpStatus.CREATED);
	}
	
	@GetMapping("getByUser/{id}")
	private ResponseEntity<List<PostDto>> getByUser(@PathVariable int id){
		return new ResponseEntity<List<PostDto>>(ps.getByUser(id),HttpStatus.OK);
	}
	
	@GetMapping("getByCategory/{id}")
	private ResponseEntity<List<PostDto>> getByCategory(@PathVariable int id){
	return new ResponseEntity<List<PostDto>>(ps.getByCategory(id),HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	private ResponseEntity<PostDto> update(@RequestBody PostDto p,@PathVariable int id){
	return new ResponseEntity<PostDto>(ps.updatePost(id, p),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delete/{id}")
	private apiResponse delete(@PathVariable int id){
		ps.deletePost(id);
		return new apiResponse("Successfully deleted");
	}
	
	@GetMapping("getAll")                 //page number starts with 0
	private ResponseEntity<PageResponse> all(   
					@RequestParam(value ="number" ,required = false,defaultValue = "0") int pnum,
					@RequestParam(value = "size",required = false,defaultValue = "4")int psize,
					@RequestParam(value="sortBy",required = false,defaultValue = "postid") String sortBy,
					@RequestParam(value="sortType", required = false, defaultValue = "ascending") String sortType){
		return new ResponseEntity<PageResponse>(ps.getAllPost(pnum,psize,sortBy,sortType),HttpStatus.OK);
	}
	
	@GetMapping("getPost/{id}")
	private ResponseEntity<PostDto> getOnePost(@PathVariable int id){
		return new ResponseEntity<PostDto>(ps.getPost(id),HttpStatus.OK);
	}
	
	@GetMapping("searchTitlehaving/{key}")
	private List<PostDto> search(@PathVariable String key){
		return ps.search(key);
	}
}
