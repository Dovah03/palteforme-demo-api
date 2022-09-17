package com.isoqualtech.plateformAPI.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isoqualtech.plateformAPI.exeption.DevisNotFoundException;
import com.isoqualtech.plateformAPI.model.Devis;
import com.isoqualtech.plateformAPI.repository.DevisRepository;

@Service
public class DevisService {
	private final DevisRepository DevisRepo;
	public DevisService(DevisRepository DevisRepo) {
		this.DevisRepo = DevisRepo;
	}
	@SuppressWarnings("deprecation")
	public Devis AddDevis(Devis devis) {
		if(DevisRepo.findByNumOffre(devis.getNumOffre()).isEmpty()) {
			devis.setDate(new Date().toGMTString());
			devis.setDatemodif(new Date().toGMTString());
		return DevisRepo.save(devis);
		}
		else return null ;

	}

	public List<Devis> FindAllDevis(){
		return DevisRepo.findAll();
	}
	public Devis FindDevisByNum_Offre(Long id) {
		return DevisRepo.findByNumOffre(id).orElseThrow(()-> new DevisNotFoundException ("Devis with Num "+id+" was not found"));
	}
	@SuppressWarnings("deprecation")
	public Devis UpdateDevis(Long id ,Devis devis) {
		Devis existingRecord = FindDevisByNum_Offre(id);
		if(DevisRepo.findByNumOffre(devis.getNumOffre()).isEmpty() || (DevisRepo.findByNumOffre(devis.getNumOffre()).isPresent() && devis.getNumOffre()==existingRecord.getNumOffre())) {
			if(devis.get_id()!=null) {
				existingRecord.set_id(devis.get_id());
			}
			if(devis.getNum_Article()!=null) {
				existingRecord.setNum_Article(devis.getNum_Article());
			}
			if(devis.getNumOffre()!=null) {
				existingRecord.setNumOffre(devis.getNumOffre());
			}
			if(devis.getP_T_HT()!=null) {
				existingRecord.setP_T_HT(devis.getP_T_HT());
			}
			if(devis.getQty()!=null) {
				existingRecord.setQty(devis.getQty());
			}
			if(devis.getP_U_HT()!=null) {
				existingRecord.setP_U_HT(devis.getP_U_HT());
			}
			if(devis.getDescription()!=null) {
				existingRecord.setDescription(devis.getDescription());
			}
			existingRecord.setDatemodif(new Date().toGMTString());
			return DevisRepo.save(existingRecord);
		}
		else return null;
	}
	public void DeleteDevis(Long id) {
		DevisRepo.deleteByNumOffre(id);
	}

}
