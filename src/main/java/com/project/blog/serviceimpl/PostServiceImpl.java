package com.project.blog.serviceimpl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.exception.ResourceNotFoundException;
import com.project.blog.repositories.Categoryrepo;
import com.project.blog.repositories.Postrepo;
import com.project.blog.repositories.User_repo;
import com.project.blog.services.PostService;
import com.project.blog.util.Category;
import com.project.blog.util.Post;
import com.project.blog.util.PostDto;
import com.project.blog.util.User;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private Postrepo pr;
	
	@Autowired
	private User_repo ur;
	
	@Autowired
	private Categoryrepo cr;
	
	@Override
	public PostDto addPost(PostDto p,int userId,int CategoryId) {
		// TODO Auto-generated method stub
		User u=this.ur.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
		Category c=this.cr.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",CategoryId));
		Post post=this.mp.map(p,Post.class);
		post.setUser(u);
		post.setDate(new Date());
		post.setCategory(c);
		pr.save(post);
		return this.mp.map(post, PostDto.class);
	}

	@Override
	public PostDto getPost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(int id, PostDto p) {
		// TODO Auto-generated method stub
		return null;
	}

}
