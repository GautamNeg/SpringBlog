package com.project.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.blog.util.Post;

@Repository
public interface Postrepo extends JpaRepository<Post, Integer>{
	
}
