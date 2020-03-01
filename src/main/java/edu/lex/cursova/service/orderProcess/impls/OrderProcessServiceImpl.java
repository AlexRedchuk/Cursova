package edu.lex.cursova.service.orderProcess.impls;

import edu.lex.cursova.dao.orderProcess.impls.OrderProcessDaoImplFake;
import edu.lex.cursova.dao.orderProcess.interfaces.IOrderProcessDao;
import edu.lex.cursova.dao.repository.OrderProcessRepository;
import edu.lex.cursova.model.Order;
import edu.lex.cursova.model.OrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class OrderProcessServiceImpl implements IOrderProcessDao {

    @Autowired
    OrderProcessDaoImplFake dao;

    @Autowired
    OrderProcessRepository repository;

    @PostConstruct
    void init(){
        List<OrderProcess> list = dao.getAll();

        repository.saveAll(list);
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
