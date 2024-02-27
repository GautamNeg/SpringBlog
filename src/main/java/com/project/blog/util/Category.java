package com.project.blog.util;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="categorydescription")
	private String categorydescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> post=new ArrayList<>();
	
	
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
