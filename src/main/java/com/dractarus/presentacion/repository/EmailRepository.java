package com.dractarus.presentacion.repository;

import com.dractarus.presentacion.entity.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<Email,String> {
}
