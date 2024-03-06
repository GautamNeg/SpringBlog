package com.project.blog.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;
	private String title;
	@Column(length=10000)
	private String content;
	private String image;
	private Date date;
		
	@ManyToOne
	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JsonBackReference
	private Category category;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Comment> comment=new ArrayList<>();
	
	public Post(int postid, String title, String content, String image, Date date, User user, Category category,
			List<Comment> comment) {
		super();
		this.postid = postid;
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.user = user;
		this.category = category;
		this.comment = comment;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Post [postid=" + postid + ", title=" + title + ", content=" + content + ", image=" + image + ", date="
				+ date + ", user=" + user + ", category=" + category + ", comment=" + comment + "]";
	}
	
}
