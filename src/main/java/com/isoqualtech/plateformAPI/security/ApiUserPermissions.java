package com.isoqualtech.plateformAPI.security;

public enum ApiUserPermissions {
	USER_READ("user:read"),
	USER_WRITE("user:write");
	
	private final String permission;

	private ApiUserPermissions(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}

}
