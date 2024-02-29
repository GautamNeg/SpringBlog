package com.project.blog.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.project.blog.exception.ResourceNotFoundException;
import com.project.blog.payload.PageResponse;
import com.project.blog.repositories.Categoryrepo;
import com.project.blog.repositories.Postrepo;
import com.project.blog.repositories.User_repo;
import com.project.blog.services.PostService;
import com.project.blog.util.Category;
import com.project.blog.util.Post;
import com.project.blog.util.PostDto;
import com.project.blog.util.User;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private Postrepo pr;
	
	@Autowired
	private User_repo ur;
	
	@Autowired
	private Categoryrepo cr;
	
	@Autowired
	private PageResponse pageR;
	
	@Override
	public PostDto addPost(PostDto p,int userId,int CategoryId) {
		// TODO Auto-generated method stub
		User u=this.ur.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
		Category c=this.cr.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",CategoryId));
		Post post=this.mp.map(p,Post.class);
		post.setUser(u);
		post.setDate(new Date());
		post.setCategory(c);
		pr.save(post);
		return this.mp.map(post, PostDto.class);
	}

	@Override
	public PostDto getPost(int id) {
		// TODO Auto-generated method stub
		return mp.map(pr.findById(id),PostDto.class);
	}

	@Override
	public void deletePost(int id) {
		pr.deleteById(id);
	}

	@Override
	public PageResponse getAllPost(int pnum,int psize,String sortBy,String sortType) {
			
		//sortBy is by what we want to sort postId or Title or anything else
		//sortType tells by what we shall sort descending or ascending 
		//here we are checking what user has send and according to that condition we will sort.
			Sort sort=sortType.equals("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending(); 
			
			org.springframework.data.domain.Pageable pp=PageRequest.of(pnum,psize,sort);   //static method
			
			Page<Post> pagepost=this.pr.findAll(pp);								  //do not returns list but returns pages
			
			List<Post> list=pagepost.getContent();									  //getting page Content
			pageR.setContent(pagepost.stream().map(w->mp.map(w, PostDto.class)).collect(Collectors.toList()));
			pageR.setLast(pagepost.isLast());						
			pageR.setPageNumber(pagepost.getNumber());
			pageR.setPageSize(pagepost.getSize());
			return pageR;
	}

	@Override
	public PostDto updatePost(int id, PostDto p) {
	     Post post=pr.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
//	     Post updatedP=mp.map(p,Post.class);			we can't update user or category from post.
//	     post.setCategory(updatedP.getCategory());
	     post.setContent(p.getContent());
	     post.setDate(new Date());
	     post.setImage(p.getImage());
	     post.setTitle(p.getTitle());
//	     post.setUser(updatedP.getUser());
	     pr.save(post);
		return mp.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getByUser(int id) {
		// TODO Auto-generated method stub
		List<Post> p=pr.findByUser(ur.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id)));
		return p.stream().map(e->this.mp.map(e, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getByCategory(int id) {
		// TODO Auto-generated method stub
	//             List<Post> p= pr.findByCategory(cr.findById(id).get()); 
		List<Post> p= pr.findByCategoryId(id); 
		return p.stream().map(e->this.mp.map(e, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> search(String keyword) {
		// TODO Auto-generated method stub
		List<Post> post=pr.findByTitleContaining(keyword);
		return post.stream().map(e->mp.map(e, PostDto.class)).collect(Collectors.toList());
	}

}
