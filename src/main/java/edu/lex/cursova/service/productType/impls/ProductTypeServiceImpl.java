package edu.lex.cursova.service.productType.impls;

import edu.lex.cursova.dao.productType.impls.ProductTypeDaoImplFake;
import edu.lex.cursova.dao.repository.ProductTypeRepository;
import edu.lex.cursova.model.Customer;
import edu.lex.cursova.model.ProductType;
import edu.lex.cursova.service.productType.interfaces.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    ProductTypeDaoImplFake dao;

    @Autowired
    ProductTypeRepository repository;

    @PostConstruct
    void init(){
        List<ProductType> list = dao.getAll();

        repository.saveAll(list);
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
