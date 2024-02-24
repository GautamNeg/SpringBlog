package com.project.blog.util;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDto {
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	private int Id;
	@NotEmpty
	@Size(min=4,message="username must be atleast of 4 character")
	private String name;
	@Email
	private String email;
	@NotEmpty
	@Size(min=7,message="password must be atleast of 7 character")
//	@Pattern(regexp = )   just generate a pattern or copy from net.
	private String password;
	private String about;
	@Override
	public String toString() {
		return "UserDto [user_Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", about=" + about + "]";
	}
	
}