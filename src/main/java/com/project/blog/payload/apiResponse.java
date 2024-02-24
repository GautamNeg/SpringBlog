package com.project.blog.payload;

public class apiResponse {

	private String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public apiResponse(String s) {
		super();
		this.s = s;
	}

	@Override
	public String toString() {
		return "apiResponse [s=" + s + "]";
	}
	
}
