package edu.lex.cursova.service.productType.impls;

import edu.lex.cursova.model.Edition;
import edu.lex.cursova.model.Printery;
import edu.lex.cursova.repository.ProductTypeRepository;
import edu.lex.cursova.model.ProductType;
import edu.lex.cursova.service.productType.interfaces.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {
    @Autowired
    ProductTypeRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public ProductType save(ProductType productType) {
        return repository.save(productType);
    }

    @Override
    public ProductType get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ProductType> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductType edit(ProductType productType) {
        return repository.save(productType);
    }

    @Override
    public ProductType delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<ProductType> search(String word) {
        return repository.findAll().stream()
                .filter(order -> order.getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ProductType> sortByName() {
        return repository.findAll().stream().sorted(Comparator.comparing(ProductType::getName))
                .collect(Collectors.toList());
    }
}
