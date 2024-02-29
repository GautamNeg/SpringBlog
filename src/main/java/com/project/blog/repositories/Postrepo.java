package com.project.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.blog.util.Category;
import com.project.blog.util.Post;
import com.project.blog.util.User;

@Repository
public interface Postrepo extends JpaRepository<Post, Integer>{
	public List<Post> findByUser(User user);
	public List<Post> findByCategoryId(int id);
	public List<Post> findByTitleContaining(String title);
}
