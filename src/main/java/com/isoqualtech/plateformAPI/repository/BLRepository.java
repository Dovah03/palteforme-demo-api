package com.isoqualtech.plateformAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.isoqualtech.plateformAPI.model.BL;

@Repository
public interface BLRepository extends MongoRepository<BL, Long>{
	Optional<BL> findByNumoffre(Long ID);
	
	void deleteByNumoffre(Long ID);

}
