package com.isoqualtech.plateformAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoqualtech.plateformAPI.model.Facture;
import com.isoqualtech.plateformAPI.service.FactureService;

@RestController
@RequestMapping("/Facture")
public class FactureController {
	@Autowired
	private FactureService fService;
	public FactureController(FactureService fService) {
		this.fService = fService;
	}
	@GetMapping(value = "/all")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<List<Facture>> getAllDevis(){
		List<Facture> Devis = fService.FindAllFacture();
		return new ResponseEntity<>(Devis, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{id}")
	@PreAuthorize("hasRole('ADMIN')"+ "|| hasRole('MODERATOR')")
	public ResponseEntity<Facture> getDevisById(@PathVariable("id") Long id){
		Facture Facture = fService.FindFactureByID(id);
		return new ResponseEntity<>(Facture, HttpStatus.OK);		
	}
	@PostMapping(value = "/create")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<Facture> createDevis(@RequestBody Facture f){
		System.out.println("inserting devis");
		Facture insertedDevis = fService.AddFacture(f);
		return new ResponseEntity<Facture>(insertedDevis, HttpStatus.CREATED);	
	}
	@PostMapping(value = "/update/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<Facture> updateDevis(@PathVariable("id") Long id , @RequestBody Facture f){
		Facture updatedFacture = fService.UpdateFacture(id,f);
		return new ResponseEntity<Facture>(updatedFacture, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')"+ "|| hasRole('MODERATOR')")
	public ResponseEntity<?> deleteDevis(@PathVariable("id") Long id){
		fService.DeleteFacture(id);
		return new ResponseEntity<Facture>(HttpStatus.OK);	
	}
}
