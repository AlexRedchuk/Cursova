package edu.lex.cursova.dao.repository;

import edu.lex.cursova.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
