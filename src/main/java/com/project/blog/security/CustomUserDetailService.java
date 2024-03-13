package com.project.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.blog.exception.ResourceNotFoundException;
import com.project.blog.repositories.User_repo;
import com.project.blog.util.User;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private User_repo ur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from Database by username
		User user=ur.findByName(username).orElseThrow(()->new ResourceNotFoundException("username", "Notfound", 0));
	
		return user;
	}

}
