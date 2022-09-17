package com.isoqualtech.plateformAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document(collection = "BL")
@Data
public class BL implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 7827630501018327795L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(nullable = false, updatable = false)
		 private ObjectId _id;
		 private Long numoffre;
		 private String ref;
		 private String date;
		 private String datemodif;
		 private String po;
		 private String desi;
		 private Long qty;
		 private String item;
}
