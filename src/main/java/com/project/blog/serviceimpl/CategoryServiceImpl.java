package com.project.blog.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.repositories.Categoryrepo;
import com.project.blog.services.CategoryService;
import com.project.blog.util.Category;
import com.project.blog.util.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired 
	private ModelMapper mp;
	
	@Autowired
	private Categoryrepo cs;

	@Override
	public CategoryDto add(CategoryDto cat) {
		// TODO Auto-generated method stub
		Category catdto=this.mp.map(cat, Category.class);
		Category c=this.cs.save(catdto);
		CategoryDto d=this.mp.map(c, CategoryDto.class);
		return d;
	}

	@Override
	public CategoryDto getCategory(int id) {
		// TODO Auto-generated method stub
		Category c=cs.findById(id).get();
		return this.mp.map(c, CategoryDto.class);
	}

	@Override
	public CategoryDto upadate(CategoryDto cat, int id) {
		// TODO Auto-generated method stub
	Category c=this.cs.findById(id).get();
	c.setcategorydescription(cat.getcategorydescription());
	c.setName(cat.getName());
	cs.save(c);
		return this.mp.map(c, CategoryDto.class);
	}

	@Override
	public void delete(int id) {
		cs.deleteById(id);
	}

	@Override
	public List<CategoryDto> all() {
		// TODO Auto-generated method stub
		List<Category> c=cs.findAll();
		return c.stream().map(e->this.mp.map(e, CategoryDto.class)).collect(Collectors.toList());
	}
}

