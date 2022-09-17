package com.isoqualtech.plateformAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Devis")
@Data
public class Devis implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3682472621367815751L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private ObjectId _id;
	private Long numOffre;
	private Long Num_Article;
	private String Description;
	private Long Qty;
	private Double P_U_HT;
	private Double P_T_HT;
	private String date;
	private String datemodif;
}
