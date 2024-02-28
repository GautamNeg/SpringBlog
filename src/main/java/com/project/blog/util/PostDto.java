package com.project.blog.util;

import java.util.Date;

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
	@Override
	public String toString() {
		return "PostDto [postid=" + postid + ", title=" + title + ", content=" + content + ", image=" + image
				+ ", date=" + date + ", user=" + user + ", category=" + category + "]";
	}
	
	
}
