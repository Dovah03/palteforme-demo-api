package com.isoqualtech.plateformAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isoqualtech.plateformAPI.exeption.FactureNotFoundException;
import com.isoqualtech.plateformAPI.model.Facture;
import com.isoqualtech.plateformAPI.repository.FactureRepository;

@Service
public class FactureService {
	private final FactureRepository FactureRepo;
	public FactureService(FactureRepository FactureRepo) {
		this.FactureRepo = FactureRepo;
	}
	public Facture AddFacture(Facture f) {
		return FactureRepo.save(f);
	}
	public List<Facture> FindAllFacture(){
		return FactureRepo.findAll();
	}
	public Facture FindFactureByID(Long id) {
		return FactureRepo.findByID(id).orElseThrow(()-> new FactureNotFoundException ("Devis with Num "+id+" was not found"));
	}
	public Facture UpdateFacture(Long id ,Facture f) {
		Facture existingRecord = FindFactureByID(id);
		if(f.get_id()!=null) {
			existingRecord.set_id(f.get_id());
		}
		if(f.getDate()!=null) {
			existingRecord.setDate(f.getDate());
		}
		if(f.getItem()!=null) {
			existingRecord.setItem(f.getItem());
		}
		if(f.getDesi()!=null) {
			existingRecord.setDesi(f.getDesi());
		}
		if(f.getQty()!=null) {
			existingRecord.setQty(f.getQty());
		}
		if(f.getP_u_ht()!=null) {
			existingRecord.setP_u_ht(f.getP_u_ht());
		}
		if(f.getM_ht()!=null) {
			existingRecord.setM_ht(f.getM_ht());
		}
		if(f.getTotal()!=null) {
			existingRecord.setTotal(f.getTotal());
		}
		return FactureRepo.save(existingRecord);
	}
	public void DeleteFacture(Long id) {
		FactureRepo.deleteByID(id);
	}

}
