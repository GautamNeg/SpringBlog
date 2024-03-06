package com.project.blog.util;

public class CommentDto {

	private int c_id;
	private String content;
	
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CommentDto(int c_id, String content) {
		super();
		this.c_id = c_id;
		this.content = content;
	}
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CommentDto [c_id=" + c_id + ", content=" + content + "]";
	}
	
	
	
}
