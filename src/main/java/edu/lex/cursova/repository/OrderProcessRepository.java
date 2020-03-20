package edu.lex.cursova.repository;

import edu.lex.cursova.model.OrderProcess;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderProcessRepository extends MongoRepository<OrderProcess, String> {
}
