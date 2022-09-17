package com.isoqualtech.plateformAPI.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isoqualtech.plateformAPI.model.Client;


@Repository
public interface ClientRepository extends MongoRepository<Client, Long> {

Optional<Client> findByMysqlid(Long ID);
	
	void deleteByMysqlid(Long ID);
}
