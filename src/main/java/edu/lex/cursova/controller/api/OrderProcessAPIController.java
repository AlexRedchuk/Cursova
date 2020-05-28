package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.OrderProcess;
import edu.lex.cursova.service.orderProcess.impls.OrderProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderProcess")
public class OrderProcessAPIController  {

    @Autowired
    OrderProcessServiceImpl service;

    @RequestMapping("/get/list")
    List<OrderProcess> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    OrderProcess getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    OrderProcess create (@RequestBody OrderProcess orderProcess) {
        return service.save(orderProcess);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    OrderProcess edit (@RequestBody OrderProcess orderProcess) {
        return service.save(orderProcess);
    }

    @RequestMapping("/delete/{id}")
    OrderProcess delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
