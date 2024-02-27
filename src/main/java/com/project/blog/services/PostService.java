package com.project.blog.services;

import java.util.List;

import com.project.blog.util.Post;
import com.project.blog.util.PostDto;

public interface PostService {

	public PostDto addPost(PostDto p,int userId,int categoryId);
	
	public PostDto updatePost(int id, PostDto p); 
	
	public PostDto getPost(int id);
	
	public void deletePost();
	
	public List<PostDto> getAllPost();
	
}
