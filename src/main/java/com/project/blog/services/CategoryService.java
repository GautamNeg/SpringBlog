package com.project.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.blog.util.CategoryDto;

public interface CategoryService {

	CategoryDto getCategory(int id);
	
	CategoryDto upadate(CategoryDto cat,int id);
	
	void delete(int id);
	
	List<CategoryDto> all();
	
	CategoryDto add(CategoryDto cat);
}
