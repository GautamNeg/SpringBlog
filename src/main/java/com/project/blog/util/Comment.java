package com.project.blog.util;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	private String content;
	@ManyToOne
	@JsonBackReference
	private Post post;
	@Override
	public String toString() {
		return "Comment [c_id=" + c_id + ", content=" + content + ", post=" + post + "]";
	}
	public Comment(int c_id, String content, Post post) {
		super();
		this.c_id = c_id;
		this.content = content;
		this.post = post;
	}
	public int getc_id() {
		return c_id;
	}
	public void setc_id(int c_id) {
		this.c_id = c_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	} 
	
}
