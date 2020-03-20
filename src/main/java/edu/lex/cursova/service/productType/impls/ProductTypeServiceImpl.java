package edu.lex.cursova.service.productType.impls;

import edu.lex.cursova.repository.ProductTypeRepository;
import edu.lex.cursova.model.ProductType;
import edu.lex.cursova.service.productType.interfaces.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {
    @Autowired
    ProductTypeRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public ProductType save(ProductType productType) {
        return null;
    }

    @Override
    public ProductType get(String id) {
        return null;
    }

    @Override
    public List<ProductType> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductType edit(ProductType productType) {
        return null;
    }

    @Override
    public ProductType delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
