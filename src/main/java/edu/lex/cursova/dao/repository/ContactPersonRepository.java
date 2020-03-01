package edu.lex.cursova.dao.repository;

import edu.lex.cursova.model.ContactPerson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactPersonRepository extends MongoRepository <ContactPerson, String> {
}
