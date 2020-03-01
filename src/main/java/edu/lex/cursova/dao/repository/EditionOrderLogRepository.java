package edu.lex.cursova.dao.repository;

import edu.lex.cursova.model.EditionOrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EditionOrderLogRepository extends MongoRepository <EditionOrderLog, String> {
}
