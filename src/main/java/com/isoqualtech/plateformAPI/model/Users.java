package com.isoqualtech.plateformAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity(name = "user")
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7389288767007781853L;
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false,updatable = false)
	private int Id;
	private String FirstName;
	private String LastName;
	private String Role;
	
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

}

