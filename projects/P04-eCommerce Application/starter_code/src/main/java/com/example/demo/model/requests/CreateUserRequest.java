package com.example.demo.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

	@JsonProperty
	private String username;
	//private String password;

	public String getUsername() {
		return username;
	}
	//public String getPassword() { return password; }


	//public void setPassword(String password) { this.password = password; }



	public void setUsername(String username) { this.username = username; }


}
