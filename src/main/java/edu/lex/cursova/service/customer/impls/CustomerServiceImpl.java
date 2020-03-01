package edu.lex.cursova.service.customer.impls;

import edu.lex.cursova.dao.customer.impls.CustomerDaoImplFake;
import edu.lex.cursova.dao.repository.CustomerRepository;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.Customer;
import edu.lex.cursova.service.customer.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerDaoImplFake dao;

    @Autowired
    CustomerRepository repository;

    @PostConstruct
    void init(){
        List<Customer> list = dao.getAll();

        repository.saveAll(list);
    }
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer get(String id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer edit(Customer customer) {
        return null;
    }

    @Override
    public Customer delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
