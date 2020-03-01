package edu.lex.cursova.dao.repository;

import edu.lex.cursova.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
