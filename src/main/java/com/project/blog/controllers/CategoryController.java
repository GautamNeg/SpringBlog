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
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.serviceimpl.CategoryServiceImpl;
import com.project.blog.services.CategoryService;
import com.project.blog.util.CategoryDto;

@RestController
@RequestMapping("category/")
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>> allCat(){
		List<CategoryDto> dto=cs.all();
		return new ResponseEntity<List<CategoryDto>>(dto,HttpStatus.OK);
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<CategoryDto> add(@RequestBody CategoryDto dto){	
		System.out.println(dto);
		CategoryDto cat=cs.add(dto);
		return new ResponseEntity<CategoryDto>(cat,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> Delete(@PathVariable int id) {
		cs.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto,@PathVariable int id){
		CategoryDto d=cs.upadate(dto, id);
		return new ResponseEntity<CategoryDto>(d,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getCategory/{id}")
	public ResponseEntity<CategoryDto> getCat(@PathVariable int id){
		CategoryDto d=cs.getCategory(id);
		return new ResponseEntity<CategoryDto>(d,HttpStatus.ACCEPTED);
	}
}
