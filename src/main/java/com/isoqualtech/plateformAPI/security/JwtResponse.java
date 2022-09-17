package com.isoqualtech.plateformAPI.security;

import com.isoqualtech.plateformAPI.Auth.ApiUser;

public class JwtResponse  {

	private String token;
	private ApiUser currentUser;

	public JwtResponse(String accessToken, ApiUser currentUser) {
		this.token = accessToken;
		this.setCurrentUser(currentUser);
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public ApiUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(ApiUser currentUser) {
		this.currentUser = currentUser;
	}

	
}