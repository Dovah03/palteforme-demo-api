package com.isoqualtech.plateformAPI.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Facture")
@Data
public class Facture implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -971684038902987587L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	 private ObjectId _id;
	 private Long ID;
	 private Date date;
	 private String item;
	 private String desi;
	 private Long qty;
	 private Long p_u_ht;
	 private Long M_ht;
	 private Long Total;
}
