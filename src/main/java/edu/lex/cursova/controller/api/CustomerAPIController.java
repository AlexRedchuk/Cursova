package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Customer;
import edu.lex.cursova.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPIController {
    @Autowired
    CustomerServiceImpl service;

    @RequestMapping("/list")
    List<Customer> getAll() {
        return service.getAll();
    }
}
