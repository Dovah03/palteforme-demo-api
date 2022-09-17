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
import com.isoqualtech.plateformAPI.model.Devis;
import com.isoqualtech.plateformAPI.service.DevisService;

@RestController
@RequestMapping("/devis")
public class DevisController {
	@Autowired
	private DevisService devisService;
	public DevisController(DevisService devisService) {
		this.devisService = devisService;
	}
	@GetMapping(value = "/all")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<List<Devis>> getAllDevis(){
		List<Devis> Devis = devisService.FindAllDevis();
		return new ResponseEntity<>(Devis, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<Devis> getDevisById(@PathVariable("id") Long id){
		Devis devis = devisService.FindDevisByNum_Offre(id);
		return new ResponseEntity<>(devis, HttpStatus.OK);		
	}
	@PostMapping(value = "/create")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<Devis> createDevis(@RequestBody Devis devis){
		Devis insertedDevis = devisService.AddDevis(devis);
		if(insertedDevis != null)
		return new ResponseEntity<Devis>(insertedDevis, HttpStatus.CREATED);
		else return new ResponseEntity<Devis>(insertedDevis, HttpStatus.BAD_REQUEST);
	}
	@PostMapping(value = "/update/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<Devis> updateDevis(@PathVariable("id") Long id , @RequestBody Devis devis){
		Devis updatedDevis = devisService.UpdateDevis(id,devis);
		if(updatedDevis != null)
			return new ResponseEntity<Devis>(updatedDevis, HttpStatus.OK);
			else return new ResponseEntity<Devis>(updatedDevis, HttpStatus.BAD_REQUEST);
		}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')"+ "|| hasRole('MODERATOR')")
	public ResponseEntity<?> deleteDevis(@PathVariable("id") Long id){
		devisService.DeleteDevis(id);
		return new ResponseEntity<Devis>(HttpStatus.OK);	
	}
}
