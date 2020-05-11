package edu.lex.cursova.service.customer.impls;

import edu.lex.cursova.repository.CustomerRepository;
import edu.lex.cursova.model.Customer;
import edu.lex.cursova.service.customer.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    CustomerRepository repository;

    @PostConstruct
    void init(){

    }
    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer edit(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Customer> search(String word) {
        return repository.findAll().stream()
                .filter(customer -> customer.getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Customer> sortByAddress() {
        return repository.findAll().stream().sorted(Comparator.comparing(Customer::getAddress))
                .collect(Collectors.toList());
    }
}
