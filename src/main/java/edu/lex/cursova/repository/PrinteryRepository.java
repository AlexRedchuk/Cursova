package edu.lex.cursova.repository;


import edu.lex.cursova.model.Printery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrinteryRepository extends MongoRepository<Printery, String> {
}