package com.isoqualtech.plateformAPI.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isoqualtech.plateformAPI.exeption.BLNotFoundException;
import com.isoqualtech.plateformAPI.model.BL;
import com.isoqualtech.plateformAPI.repository.BLRepository;

@Service
public class BLService {
	private final BLRepository BLRepo;
	public BLService(BLRepository BLRepo) {
		this.BLRepo = BLRepo;
	}
	@SuppressWarnings("deprecation")
	public BL AddBL(BL bl) {
		if(BLRepo.findByNumoffre(bl.getNumoffre()).isEmpty()) {
			bl.setDate(new Date().toGMTString());
			bl.setDatemodif(new Date().toGMTString());
			return BLRepo.save(bl);
			}
			else return null ;
	}
	public List<BL> FindAllBL(){
		return BLRepo.findAll();
	}
	public BL FindBLByID(Long id) {
		return BLRepo.findByNumoffre(id).orElseThrow(()-> new BLNotFoundException ("Devis with Num "+id+" was not found"));
	}
	@SuppressWarnings("deprecation")
	public BL UpdateBL(Long id ,BL bl) { 
		BL existingRecord = FindBLByID(id);
		if(BLRepo.findByNumoffre(bl.getNumoffre()).isEmpty() 
				|| (BLRepo.findByNumoffre(bl.getNumoffre()).isPresent() 
						&& bl.getNumoffre()==existingRecord.getNumoffre())) {
			System.out.println("iffat");
			if(bl.get_id()!=null) {
				existingRecord.set_id(bl.get_id());
			}
			if(bl.getNumoffre()!=null) {
				existingRecord.setNumoffre(bl.getNumoffre());
			}
			if(bl.getDate()!=null) {
				existingRecord.setDate(bl.getDate());
			}
			if(bl.getPo()!=null) {
				existingRecord.setPo(bl.getPo());
			}
			if(bl.getDesi()!=null) {
				existingRecord.setDesi(bl.getDesi());
			}
			if(bl.getQty()!=null) {
				existingRecord.setQty(bl.getQty());
			}
			if(bl.getDesi()!=null) {
				existingRecord.setDesi(bl.getDesi());
			}
			if(bl.getItem()!=null) {
				existingRecord.setItem(bl.getItem());
			}
			existingRecord.setDatemodif(new Date().toGMTString());
			return BLRepo.save(existingRecord);
		}
		else return null;
	}
	public void DeleteBL(Long id) {
		BLRepo.deleteByNumoffre(id);
	}

}
