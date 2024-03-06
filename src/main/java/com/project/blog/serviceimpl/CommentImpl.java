package com.project.blog.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.exception.ResourceNotFoundException;
import com.project.blog.repositories.CommentRepo;
import com.project.blog.repositories.Postrepo;
import com.project.blog.services.CommentService;
import com.project.blog.util.Comment;
import com.project.blog.util.CommentDto;
import com.project.blog.util.Post;

@Service
public class CommentImpl implements CommentService{

	@Autowired
	Postrepo pr;
	
	@Autowired
	CommentRepo cr;
	
	@Autowired
	ModelMapper mp;
	
	@Override
	public CommentDto createComment(CommentDto commentdto, Integer Postid) {
		// TODO Auto-generated method stub
		Post post=pr.findById(Postid).orElseThrow(()->new ResourceNotFoundException("post", "id", Postid));
		
		Comment com=mp.map(commentdto, Comment.class);
		com.setPost(post);
		cr.save(com);
		
		return mp.map(com, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer cid) {
		// TODO Auto-generated method stub
		cr.deleteById(cid);
	}

}
