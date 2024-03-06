package com.project.blog.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDto {

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Integer postid;
	private String title;
	private String content;
	private String image;
	private Date date;
	private UserDto user;
	private CategoryDto category;
	private List<Comment> comment=new ArrayList(); 

	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
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
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public PostDto(Integer postid, String title, String content, String image, Date date, UserDto user,
			CategoryDto category, List<Comment> comment) {
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
	@Override
	public String toString() {
		return "PostDto [postid=" + postid + ", title=" + title + ", content=" + content + ", image=" + image
				+ ", date=" + date + ", user=" + user + ", category=" + category + ", comment=" + comment + "]";
	}
}
