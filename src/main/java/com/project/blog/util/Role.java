package com.project.blog.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Role_id;
	private String name;
	
	@ManyToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	Set<User> users=new HashSet();

	public Integer getRole_id() {
		return Role_id;
	}

	public void setRole_id(Integer role_id) {
		Role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer role_id, String name, Set<User> users) {
		super();
		Role_id = role_id;
		this.name = name;
		this.users = users;
	}
	
}
