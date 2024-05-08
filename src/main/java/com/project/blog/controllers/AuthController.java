package com.project.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.exception.usernameorpasswordIncorrect;
import com.project.blog.payload.jwtAuthRequest;
import com.project.blog.payload.jwtAuthResponse;
import com.project.blog.security.JwtTokenHelper;
import com.project.blog.serviceimpl.UserServiceImpl;
import com.project.blog.util.UserDto;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
	
	@Autowired
	private UserServiceImpl usimpl;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<jwtAuthResponse> createToken(@RequestBody jwtAuthRequest request) throws Exception{
		
		this.authenticate(request.getUsername(),request.getPassword());
		UserDetails userByUsername = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userByUsername);
		jwtAuthResponse response=new jwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<jwtAuthResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto userdto){
		UserDto user=usimpl.registerUser(userdto);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);
	}
	
	
	private void authenticate(String name,String password) throws Exception {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(name, password);
		try {
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	}
		catch(Exception e){
			System.out.println("user is disable");
			throw new usernameorpasswordIncorrect("invalid username or password!");
		}
	}
}
