package com.project.blog.services;

import com.project.blog.util.CommentDto;


public interface CommentService {

	CommentDto createComment(CommentDto commentdto,Integer Postid);
	
	void deleteComment(Integer cid);
}
