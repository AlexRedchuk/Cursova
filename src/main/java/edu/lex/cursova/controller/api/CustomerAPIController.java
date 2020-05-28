package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Customer;
import edu.lex.cursova.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPIController {
    @Autowired
    CustomerServiceImpl service;

    @RequestMapping("/get/list")
    List<Customer> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Customer getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Customer create (@RequestBody Customer customer) {
        return service.save(customer);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Customer edit (@RequestBody Customer customer) {
        return service.save(customer);
    }

    @RequestMapping("/delete/{id}")
    Customer delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
