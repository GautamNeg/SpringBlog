package com.project.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.services.CommentService;
import com.project.blog.util.CommentDto;

@RestController
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private CommentService cs;
	
	@PostMapping("/create/{id}")
	public ResponseEntity<CommentDto> create(@RequestBody CommentDto cmtdto, @PathVariable Integer id){
	 CommentDto cdto = cs.createComment(cmtdto, id);
		return new ResponseEntity<CommentDto>(cdto,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable Integer cid) {
		cs.deleteComment(cid);
	}
}
