package edu.lex.cursova.service.productType.interfaces;

import edu.lex.cursova.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    ProductType save(ProductType productType);
    ProductType get(String id);
    List<ProductType> getAll();
    ProductType edit(ProductType productType);
    ProductType delete (String id);
}
