package edu.lex.cursova.repository;

import edu.lex.cursova.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
