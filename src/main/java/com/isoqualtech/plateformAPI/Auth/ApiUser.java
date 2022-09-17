package com.isoqualtech.plateformAPI.Auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.isoqualtech.plateformAPI.model.User;

public class ApiUser implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private final Collection<? extends GrantedAuthority> grantedAuthorities;
	private final Long id;
	private final String firstName;
	private final String lastName;
	@JsonProperty(access = Access.WRITE_ONLY)
	private final String password;
	private final String company;
	private final String email;
	private final String username;
	private final String role;
	private final boolean isAccountNonExpired;
	private final boolean isAccountNonLocked;
	private final boolean isCredentialsNonExpired;
	private final boolean isEnabled;
	private String profileImageUrl;
	private String lastloginDate;
	private String Description;

	
	public ApiUser(User user) {
		this.id = user.getId();
		this.grantedAuthorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.company = user.getCompany();
		this.email = user.getEmail();
		this.role = user.getRole();
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = user.isIsntLocked();
		this.isCredentialsNonExpired = true;
		this.isEnabled = user.isActive();
		this.profileImageUrl = user.getProfileImageUrl();
		this.lastloginDate = user.getLastloginDate();
		this.Description = user.getDescription();
	}
	public ApiUser(User user,List<GrantedAuthority> authorities) {
		this.id=user.getId();
		this.grantedAuthorities = authorities;
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.role = user.getRole();
		this.email = user.getEmail();
		this.company = user.getCompany();
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = user.isIsntLocked();
		this.isCredentialsNonExpired = true;
		this.isEnabled = user.isActive();
		this.profileImageUrl = user.getProfileImageUrl();
		this.lastloginDate = user.getLastloginDate();
		this.Description = user.getDescription();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

	public String getRole() {
		return role;
	}

	public static ApiUser build(User user) {
		List<GrantedAuthority> authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		return new ApiUser(user,authorities);
	}
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public String getLastloginDate() {
		return lastloginDate;
	}
	public void setLastloginDate(String lastloginDate) {
		this.lastloginDate = lastloginDate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCompany() {
		return company;
	}
}
