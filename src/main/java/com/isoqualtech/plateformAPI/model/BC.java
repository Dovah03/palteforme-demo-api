package com.isoqualtech.plateformAPI.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "BC")
@Data
public class BC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7827630501018327795L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	 private ObjectId _id;
	 private Long numoffre;
	 private String date;
	 private String datemodif;
	 private String ref;
	 private String desi;
	 private Long qty;
	 private Double p_u_ht;
	 private Double m_ht;
	 private Double total;
}
