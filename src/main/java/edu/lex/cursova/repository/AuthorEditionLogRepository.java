package edu.lex.cursova.repository;

import edu.lex.cursova.model.AuthorEditionLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorEditionLogRepository extends MongoRepository <AuthorEditionLog, String> {
}
