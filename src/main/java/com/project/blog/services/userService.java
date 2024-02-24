package com.project.blog.services;

import java.util.List;
import com.project.blog.util.UserDto;

public interface userService {

	UserDto createUser(UserDto user);
	
	UserDto updateUser(int id,UserDto user);
	
	UserDto getUserById(int id);
	
	void deleteUser(int id);
	
	List<UserDto> getAllUser(); 
}
