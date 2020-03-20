package edu.lex.cursova.repository;

import edu.lex.cursova.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
