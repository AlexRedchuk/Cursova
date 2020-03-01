package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Order;
import edu.lex.cursova.service.order.impls.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderAPIController  {

    @Autowired
    OrderServiceImpl service;

    @RequestMapping("/list")
    List<Order> getAll() {
        return service.getAll();
    }
}