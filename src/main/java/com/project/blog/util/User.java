package com.project.blog.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class User {

	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_Id;
	@Column(name="name")
	private String name;
	public Set<Role> getrole() {
		return role;
	}
	public void setrole(Set<Role> role) {
		this.role = role;
	}
	public User(int user_Id, String name, String email, String password, String about, List<Post> post,
			Set<Role> role) {
		super();
		this.user_Id = user_Id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.post = post;
		this.role = role;
	}
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="about")
	private String about;
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Post> post=new ArrayList<>();		//we create new list because of one to many relationship

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="users_roles",
	joinColumns = {@JoinColumn(name="user",referencedColumnName = "user_Id")},
	inverseJoinColumns = {@JoinColumn(name="role",referencedColumnName = "Role_id")})
	Set<Role> role=new HashSet();
}
