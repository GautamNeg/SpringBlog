package com.project.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.blog.security.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
		@Autowired
		CustomUserDetailService customUserDetailService;
	
		@Bean 	//now we are creating our own springsecurityfilterchain 
		public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
			http.authenticationProvider(daoAuthenticationProvider())
			.csrf().disable().authorizeRequests().anyRequest()
			.authenticated().and().httpBasic();
		
			return http.build(); 	
		}

		 @Bean
		    public PasswordEncoder encoder() {
		        return new BCryptPasswordEncoder();
		    }
		 
		 @Bean
		  public DaoAuthenticationProvider daoAuthenticationProvider() {
			 DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
			 provider.setUserDetailsService(customUserDetailService);
			 provider.setPasswordEncoder(encoder());
			 return provider;	 
		 }
}

