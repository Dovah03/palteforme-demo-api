package com.isoqualtech.plateformAPI.security;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.isoqualtech.plateformAPI.security.ApiUserPermissions.*;

public enum ApiUserRoles {
	ADMIN(Sets.newHashSet(USER_READ,USER_WRITE)),
	USER(Sets.newHashSet(USER_READ)),
	CLIENT(Sets.newHashSet());
	
	private final Set<ApiUserPermissions> permissions;
	
	ApiUserRoles(Set<ApiUserPermissions> permissions){
		this.permissions = permissions;
	}
	
	public Set<ApiUserPermissions> getPermissions() {
		return permissions;
	}
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissions;
	}
	
	
}
