package edu.lex.cursova.dao.customer.impls;

import edu.lex.cursova.dao.customer.interfaces.ICustomerDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImplFake implements ICustomerDao {

    @Autowired
    DataSet dataSet;

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
        return dataSet.getCustomers();
    }

    @Override
    public Customer edit(Customer customer) {
        return null;
    }

    @Override
    public Customer delete(String id) {
        return null;
    }
}
