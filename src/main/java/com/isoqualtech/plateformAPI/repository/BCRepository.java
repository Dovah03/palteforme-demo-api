package com.isoqualtech.plateformAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isoqualtech.plateformAPI.model.BC;

@Repository
public interface BCRepository extends MongoRepository<BC, Long>{
	Optional<BC> findByNumoffre(Long ID);
	
	void deleteByNumoffre(Long ID);

}
