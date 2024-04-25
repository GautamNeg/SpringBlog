package com.project.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.blog.security.CustomUserDetailService;
import com.project.blog.security.JwtAuthenticationEntryPoint;
import com.project.blog.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
		@Autowired
		JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
		
		@Autowired
		JwtAuthenticationFilter jwtAuthenticationFilter;
	
		@Autowired
		CustomUserDetailService customUserDetailService;
	
		@Bean 	//now we are creating our own springsecurityfilterchain 
		public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
			http
			.authenticationProvider(daoAuthenticationProvider())
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.requestMatchers("/api/v1/auth/login").permitAll()
			.anyRequest()
			.authenticated()
			.and().exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
			http.addFilterBefore(this.jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
			return http.build(); 	
		}
		
		@Bean
		public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception{
			return configuration.getAuthenticationManager();
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

