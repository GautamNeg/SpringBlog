package com.project.blog.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//get token
		String requestToken=request.getHeader("Authorization");  //authorization is key in header as in header we have key value pair
		System.out.println(requestToken);
		
		
		String username=null;
		String token=null;
		
		if(requestToken!=null&&requestToken.startsWith("Bearer")) {
			token=requestToken.substring(7);
			try {
			username=jwtTokenHelper.getUsernameFromToken(token);
			}
			catch(IllegalArgumentException a){
				System.out.println("unable to get jwt token");
			}
			catch(ExpiredJwtException e) {
				System.out.println("Token expired");
			}
			catch(MalformedJwtException s) {
				System.out.println("invalid jwt");
			}
		}
		else
		{
			System.out.println("Jwt token fault");
		}
		
		
		//once we got the token now we will validate

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {


            //fetch user detail from username
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(this.jwtTokenHelper.validateToken(token, userDetails)){
            	//everthing is ok 
                //set the authentication
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } 
            else {
            	System.out.println("Invalid jwt Token");
            }

        }
        else {
        	System.out.println("Username is null or context is not null");
        }

        filterChain.doFilter(request, response);

	}

}
