package edu.lex.cursova.dao.repository;

import edu.lex.cursova.model.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductTypeRepository extends MongoRepository<ProductType, String> {

}
