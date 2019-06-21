package com.ombrodrigo.crudrest.repository;

import com.ombrodrigo.crudrest.domain.Conta;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends MongoRepository<Conta, String> {
     
}