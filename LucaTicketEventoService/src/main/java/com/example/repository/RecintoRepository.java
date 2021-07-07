package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Recinto;

public interface RecintoRepository extends MongoRepository<Recinto,String>{

}
