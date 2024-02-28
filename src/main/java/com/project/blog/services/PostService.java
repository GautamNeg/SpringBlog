package com.project.blog.services;

import java.util.List;

import com.project.blog.util.Post;
import com.project.blog.util.PostDto;

public interface PostService {

	public PostDto addPost(PostDto p,int userId,int categoryId);
	
	public PostDto updatePost(int id, PostDto p); 
	
	public PostDto getPost(int id);
	
	public void deletePost(int id);
	
	public List<PostDto> getAllPost(int a,int b);
	
	public List<PostDto> getByUser(int id);
	
	public List<PostDto> getByCategory(int id);
	
}
