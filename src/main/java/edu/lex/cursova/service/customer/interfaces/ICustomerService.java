package edu.lex.cursova.service.customer.interfaces;

import edu.lex.cursova.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer save(Customer customer);
    Customer get(String id);
    List<Customer> getAll();
    Customer edit(Customer customer);
    Customer delete(String id);
}
