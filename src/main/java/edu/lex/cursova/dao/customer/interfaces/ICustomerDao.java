package edu.lex.cursova.dao.customer.interfaces;

import edu.lex.cursova.model.Customer;

import java.util.List;

public interface ICustomerDao {
    Customer save(Customer customer);
    Customer get(String id);
    List<Customer> getAll();
    Customer edit(Customer customer);
    Customer delete(String id);
}
