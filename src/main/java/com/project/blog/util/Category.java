package com.project.blog.util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="categorydescription")
	private String categorydescription;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", categorydescription=" + categorydescription + "]";
	}
	public Category(Integer id, String name,String categorydescription) {
		super();
		this.id = id;
		this.name = name;
		this.categorydescription= categorydescription;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcategorydescription() {
		return categorydescription;
	}
	public void setcategorydescription(String name) {
		this.categorydescription = name;
	}
	
}
