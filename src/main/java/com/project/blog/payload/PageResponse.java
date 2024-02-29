package com.project.blog.payload;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.blog.util.PostDto;

@Component
public class PageResponse {

	private List<PostDto> content;
	private int PageNumber;
	public PageResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PageResponse [content=" + content + ", PageNumber=" + PageNumber + ", PageSize=" + PageSize + ", Last="
				+ Last + "]";
	}
	public PageResponse(List<PostDto> content, int pageNumber, int pageSize, Boolean last) {
		super();
		this.content = content;
		PageNumber = pageNumber;
		PageSize = pageSize;
		Last = last;
	}
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return PageNumber;
	}
	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public boolean getLast() {
		return Last;
	}
	public void setLast(Boolean last) {
		Last = last;
	}
	private int PageSize;
	private boolean Last;
	
}
