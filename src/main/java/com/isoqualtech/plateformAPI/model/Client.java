package com.isoqualtech.plateformAPI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;



@Document(collection = "Clients")
@Data
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3235270540361219930L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ObjectId _id;
	private Long mysqlid;
	private String FirstName;
	private String LastName;
	private String username;
	private String email;
	private String company;
	private List<Long> BCID_list = new ArrayList<Long>();
	private List<Long> BLID_list = new ArrayList<Long>();;
	private List<Long> DevisID_list = new ArrayList<Long>();;
	private List<Long> FactureID_list = new ArrayList<Long>();;
	
	
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
	public void addDevis(Long ID) {
		DevisID_list.add(ID);
	}
	public void addBC(Long ID) {
		BCID_list.add(ID);
	}
	public void addBL(Long ID) {
		BLID_list.add(ID);
	}
	public void addFacture(Long ID) {
		FactureID_list.add(ID);
	}
	public void RemoveDevis(Long ID) {
		DevisID_list.remove(ID);
	}
	public void RemoveBC(Long ID) {
		BCID_list.remove(ID);
	}
	public void RemoveBL(Long ID) {
		BLID_list.remove(ID);
	}
	public void RemoveFacture(Long ID) {
		FactureID_list.remove(ID);
	}
}
