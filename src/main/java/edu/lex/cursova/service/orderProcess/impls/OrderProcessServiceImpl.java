package edu.lex.cursova.service.orderProcess.impls;


import edu.lex.cursova.repository.OrderProcessRepository;
import edu.lex.cursova.model.OrderProcess;
import edu.lex.cursova.service.orderProcess.interfaces.IOrderProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class OrderProcessServiceImpl implements IOrderProcessService {
    @Autowired
    OrderProcessRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public OrderProcess save(OrderProcess orderProcess) {
        return null;
    }

    @Override
    public OrderProcess get(String id) {
        return null;
    }

    @Override
    public List<OrderProcess> getAll() {
        return repository.findAll();
    }

    @Override
    public OrderProcess edit(OrderProcess orderProcess) {
        return null;
    }

    @Override
    public OrderProcess delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
