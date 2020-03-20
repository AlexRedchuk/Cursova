package edu.lex.cursova.repository;

import edu.lex.cursova.model.EditionDirection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EditionDirectionRepository extends MongoRepository<EditionDirection, String> {
}
