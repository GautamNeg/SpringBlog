package com.project.blog.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.exception.ResourceNotFoundException;
import com.project.blog.repositories.User_repo;
import com.project.blog.services.userService;
import com.project.blog.util.User;
import com.project.blog.util.UserDto;

@Service
public class UserServiceImpl implements userService{

	@Autowired
	private User_repo userrepo;
	@Autowired
	private ModelMapper mp;
	
	@Override
	public UserDto createUser(UserDto userdto) {
		// TODO Auto-generated method stub
		User user=this.Dtotouser(userdto);
		userrepo.save(user);
		return this.usertoDto(user);
	}

	@Override
	public UserDto updateUser(int id,UserDto user) {
		// TODO Auto-generated method stub
		User olduser=userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id",id)); //here we are creating our own  exception so using orElseThrow
		olduser.setAbout(user.getAbout());
		olduser.setEmail(user.getEmail());
		olduser.setName(user.getName());
		olduser.setPassword(user.getPassword());
		userrepo.save(olduser);
		return this.usertoDto(olduser);
	}

	@Override
	public UserDto getUserById(int id) {
		User user=userrepo.findById(id).get();   //here automatically spring will throw noSuchElementException so no need to create class
		UserDto ud=this.usertoDto(user);
		return ud;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(id);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<UserDto> ud=new ArrayList<>();
		List<User> user=userrepo.findAll();
		for(User u: user) {
			ud.add(this.usertoDto(u));
		}
		
	// List<UserDto> udto = user.stream().map(u->this.usertoDto(u)).collect(Collectors.toList());	
		return ud;
	}
	
	public User Dtotouser(UserDto udto) {
		User user=mp.map(udto, User.class);
//		user.setUser_Id(udto.getId());
//		user.setEmail(udto.getEmail());
//		user.setName(udto.getName());
//		user.setAbout(udto.getAbout());
//		user.setPassword(udto.getPassword());
	
		return user;
	}
	public UserDto usertoDto(User user) {
		UserDto userDto=mp.map(user, UserDto.class);
//		userDto.setId(user.getUser_Id());
//		userDto.setEmail(user.getEmail());
//		userDto.setName(user.getName());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;
	}
}
