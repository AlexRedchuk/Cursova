package edu.lex.cursova.dao.repository;

import edu.lex.cursova.model.Edition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EditionRepository extends MongoRepository <Edition, String> {
}
