package edu.lex.cursova.service.order.impls;

import edu.lex.cursova.dao.order.impls.OrderDaoImplFake;
import edu.lex.cursova.dao.repository.OrderRepository;
import edu.lex.cursova.model.Order;
import edu.lex.cursova.service.order.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderDaoImplFake dao;

    @Autowired
    OrderRepository repository;

    @PostConstruct
    void init(){
        List<Order> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order get(String id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order edit(Order order) {
        return null;
    }

    @Override
    public Order delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
