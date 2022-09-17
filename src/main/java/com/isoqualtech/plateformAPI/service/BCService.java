package com.isoqualtech.plateformAPI.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isoqualtech.plateformAPI.exeption.BCNotFoundException;
import com.isoqualtech.plateformAPI.model.BC;
import com.isoqualtech.plateformAPI.repository.BCRepository;

@Service
public class BCService {
	private final BCRepository BCRepo;
	public BCService(BCRepository BCRepo) {
		this.BCRepo = BCRepo;
	}
	@SuppressWarnings("deprecation")
	public BC AddBC(BC bc) {
		if(BCRepo.findByNumoffre(bc.getNumoffre()).isEmpty()) {
			bc.setDate(new Date().toGMTString());
			bc.setDatemodif(new Date().toGMTString());
			return BCRepo.save(bc);
			}
			else return null ;
	}
	public List<BC> FindAllBC(){
		return BCRepo.findAll();
	}
	public BC FindBCByID(Long id) {
		return BCRepo.findByNumoffre(id).orElseThrow(()-> new BCNotFoundException ("Devis with Num "+id+" was not found"));
	}
	@SuppressWarnings("deprecation")
	public BC UpdateBC(Long id ,BC bc) {
		BC existingRecord = FindBCByID(id);
		if(BCRepo.findByNumoffre(bc.getNumoffre()).isEmpty() || (BCRepo.findByNumoffre(bc.getNumoffre()).isPresent() && bc.getNumoffre()==existingRecord.getNumoffre())) {
			if(bc.get_id()!=null) {
				existingRecord.set_id(bc.get_id());
			}
			if(bc.getNumoffre()!=null) {
				existingRecord.setNumoffre(bc.getNumoffre());
			}
			if(bc.getDate()!=null) {
				existingRecord.setDate(bc.getDate());
			}
			if(bc.getRef()!=null) {
				existingRecord.setRef(bc.getRef());
			}
			if(bc.getDesi()!=null) {
				existingRecord.setDesi(bc.getDesi());
			}
			if(bc.getQty()!=null) {
				existingRecord.setQty(bc.getQty());
			}
			if(bc.getP_u_ht()!=null) {
				existingRecord.setP_u_ht(bc.getP_u_ht());
			}
			if(bc.getM_ht()!=null) {
				existingRecord.setM_ht(bc.getM_ht());
			}
			if(bc.getTotal()!=null) {
				existingRecord.setTotal(bc.getTotal());
			}
			existingRecord.setDatemodif(new Date().toGMTString());
			return BCRepo.save(existingRecord);
		}
		else return null;
	}
	public void DeleteBC(Long id) {
		BCRepo.deleteByNumoffre(id);
	}

}
