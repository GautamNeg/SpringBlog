package com.project.blog.util;

public class CategoryDto {
	
	private Integer id;
	private String name;
	private String categorydescription;
	
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
public CategoryDto(String name, Integer id, String categorydescription) {
		super();
		this.name = name;
		this.id = id;
		this.categorydescription = categorydescription;
	}
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getcategorydescription() {
		return categorydescription;
	}
	public void setcategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", categorydescription=" + categorydescription + "]";
	}
}
