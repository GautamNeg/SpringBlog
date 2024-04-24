package com.project.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.blog.serviceimpl.UserServiceImpl;
import com.project.blog.util.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user/")
public class userController {

	@Autowired
	private UserServiceImpl usimpl;
	
	
	@GetMapping("getUser/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
	UserDto userdto=this.usimpl.getUserById(id);
	return new ResponseEntity<UserDto>(userdto,HttpStatus.OK);
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto udto) {
		System.out.println(udto);
		UserDto userdto=usimpl.createUser(udto);
		return new ResponseEntity<UserDto>(userdto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> first() {
		List<UserDto> boo=usimpl.getAllUser();
		ResponseEntity<List<UserDto>> rs=new ResponseEntity(boo,HttpStatus.OK);
		return rs;
	}
	
	@PutMapping("update/{id}")
	public UserDto updatenow(@PathVariable int id,@RequestBody UserDto udto) {
		UserDto udt=usimpl.updateUser(id, udto);
		return udt;
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable int id){
		usimpl.deleteUser(id);
	return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
}
