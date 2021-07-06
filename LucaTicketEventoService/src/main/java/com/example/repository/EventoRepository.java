package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Evento;

public interface EventoRepository extends MongoRepository<Evento,String> {

}
