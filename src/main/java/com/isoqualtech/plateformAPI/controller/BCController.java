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

import com.isoqualtech.plateformAPI.model.BC;
import com.isoqualtech.plateformAPI.service.BCService;

@RestController
@RequestMapping("/bc")
public class BCController {
	@Autowired
	private BCService bcService;
	public BCController(BCService bcService) {
		this.bcService = bcService;
	}
	@GetMapping(value = "/all")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<List<BC>> getAllBC(){
		List<BC> Devis = bcService.FindAllBC();
		return new ResponseEntity<>(Devis, HttpStatus.OK);
	}
	@GetMapping(value = "/find/{id}")
	@PreAuthorize("hasRole('ADMIN')"+ "|| hasRole('MODERATOR')"+ "|| hasRole('USER')")
	public ResponseEntity<BC> getBCById(@PathVariable("id") Long id){
		BC BC = bcService.FindBCByID(id);
		return new ResponseEntity<>(BC, HttpStatus.OK);		
	}
	@PostMapping(value = "/add")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<BC> createBC(@RequestBody BC bc){
		BC insertedBC = bcService.AddBC(bc);
		if(insertedBC !=null)
			return new ResponseEntity<BC>(insertedBC, HttpStatus.CREATED);
		else return new ResponseEntity<BC>(insertedBC, HttpStatus.BAD_REQUEST);	
	}
	@PostMapping(value = "/update/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<BC> updateBC(@PathVariable("id") Long id , @RequestBody BC bc){
		BC updatedBC = bcService.UpdateBC(id,bc);
		if(updatedBC != null)
			return new ResponseEntity<BC>(updatedBC, HttpStatus.OK);
			else return new ResponseEntity<BC>(updatedBC, HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')"+ "|| hasRole('MODERATOR')")
	public ResponseEntity<?> deleteBC(@PathVariable("id") Long id){
		bcService.DeleteBC(id);
		return new ResponseEntity<BC>(HttpStatus.OK);	
	}
}
