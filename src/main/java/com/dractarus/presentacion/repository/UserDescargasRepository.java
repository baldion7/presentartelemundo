package com.dractarus.presentacion.repository;

import com.dractarus.presentacion.entity.UserDescargas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDescargasRepository extends MongoRepository<UserDescargas,String> {

}
