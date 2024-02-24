package com.project.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.blog.util.User;

@Repository
public interface User_repo extends JpaRepository<User, Integer>{

}
