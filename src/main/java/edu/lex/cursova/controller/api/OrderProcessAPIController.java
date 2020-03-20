package edu.lex.cursova.controller.api;


import edu.lex.cursova.model.OrderProcess;
import edu.lex.cursova.service.orderProcess.impls.OrderProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderProcess")
public class OrderProcessAPIController  {

    @Autowired
    OrderProcessServiceImpl service;

    @RequestMapping("/list")
    List<OrderProcess> getAll() {
        return service.getAll();
    }
}
