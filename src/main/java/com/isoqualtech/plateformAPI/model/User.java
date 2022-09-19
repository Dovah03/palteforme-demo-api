	package com.isoqualtech.plateformAPI.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity(name = "user_Auth")
@Table(name = "user_Auth")
@DynamicUpdate
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7389288767007781853L;
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false,updatable = false)
	private Long Id;
	private String FirstName;
	private String LastName;
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String email;
	private String company;
	private String profileImageUrl;
	private String lastloginDate;
	private Date lastloginDateDisplay;
	private String JoinDate;
	private String Role;
	private String Description;
	private boolean isActive;
	private boolean isntLocked;
	
	public User() {}
	
	public User(Long id, String firstName, String lastName, String username, String password,String company, String email,
			String profileImageUrl, String lastloginDate, Date lastloginDateDisplay, String joinDate, String role,
			boolean isActive, boolean isntLocked, String Description) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.company = company;
		this.profileImageUrl = profileImageUrl;
		this.lastloginDate = lastloginDate;
		this.lastloginDateDisplay = lastloginDateDisplay;
		JoinDate = joinDate;
		Role = role;
		this.isActive = isActive;
		this.isntLocked = isntLocked;
		this.Description = Description;
		
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public void setLastloginDate(String string) {
		this.lastloginDate = string;
	}
	public Date getLastloginDateDisplay() {
		return lastloginDateDisplay;
	}
	public void setLastloginDateDisplay(Date lastloginDateDisplay) {
		this.lastloginDateDisplay = lastloginDateDisplay;
	}
	public String getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(String string) {
		JoinDate = string;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isIsntLocked() {
		return isntLocked;
	}
	public void setIsntLocked(boolean isntLocked) {
		this.isntLocked = isntLocked;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
