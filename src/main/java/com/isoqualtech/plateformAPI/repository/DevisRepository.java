package com.isoqualtech.plateformAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isoqualtech.plateformAPI.model.Devis;

@Repository
public interface DevisRepository extends MongoRepository<Devis, Long>{
	Optional<Devis> findByNumOffre(Long Num_Offre);
	
	void deleteByNumOffre(Long Num_Offre);

}
