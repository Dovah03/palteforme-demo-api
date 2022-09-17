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

import com.isoqualtech.plateformAPI.model.BL;
import com.isoqualtech.plateformAPI.service.BLService;

@RestController
@RequestMapping("/bl")
public class BLController {
	@Autowired
	private BLService blService;
	public BLController(BLService blService) {
		this.blService = blService;
	}
	@GetMapping(value = "/all")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<List<BL>> getAllDevis(){
		List<BL> Devis = blService.FindAllBL();
		return new ResponseEntity<>(Devis, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{id}")
	@PreAuthorize("hasRole('ADMIN')"+ "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<BL> getBLById(@PathVariable("id") Long id){
		BL BL = blService.FindBLByID(id);
		return new ResponseEntity<>(BL, HttpStatus.OK);		
	}
	@PostMapping(value = "/add")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<BL> createDevis(@RequestBody BL bl){
		System.out.println("inserting devis");
		BL insertedBL = blService.AddBL(bl);
		if(insertedBL != null)
			return new ResponseEntity<BL>(insertedBL, HttpStatus.OK);
		else return new ResponseEntity<BL>(insertedBL, HttpStatus.BAD_REQUEST);
	}
	@PostMapping(value = "/update/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<BL> updateDevis(@PathVariable("id") Long id , @RequestBody BL bl){
		BL updatedBL = blService.UpdateBL(id,bl);
		if(updatedBL != null)
			return new ResponseEntity<BL>(updatedBL, HttpStatus.OK);
		else return new ResponseEntity<BL>(updatedBL, HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')"+ "|| hasRole('MODERATOR')")
	public ResponseEntity<?> deleteDevis(@PathVariable("id") Long id){
		blService.DeleteBL(id);
		return new ResponseEntity<BL>(HttpStatus.OK);	
	}
}
