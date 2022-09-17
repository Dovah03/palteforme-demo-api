package com.isoqualtech.plateformAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.isoqualtech.plateformAPI.model.Facture;

@Repository
public interface FactureRepository extends MongoRepository<Facture, Long>{
	Optional<Facture> findByID(Long ID);
	
	void deleteByID(Long ID);

}
