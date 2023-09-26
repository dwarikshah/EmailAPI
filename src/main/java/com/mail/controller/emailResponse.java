package com.mail.controller;

public class emailResponse {
	
	String token ;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public emailResponse(String token) {
		super();
		this.token = token;
	}

	public emailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
