package edu.lex.cursova.service.orderProcess.impls;


import edu.lex.cursova.repository.OrderProcessRepository;
import edu.lex.cursova.model.OrderProcess;
import edu.lex.cursova.service.orderProcess.interfaces.IOrderProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderProcessServiceImpl implements IOrderProcessService {
    @Autowired
    OrderProcessRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public OrderProcess save(OrderProcess orderProcess) {
        return repository.save(orderProcess);
    }

    @Override
    public OrderProcess get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<OrderProcess> getAll() {
        return repository.findAll();
    }

    @Override
    public OrderProcess edit(OrderProcess orderProcess) {
        return repository.save(orderProcess);
    }

    @Override
    public OrderProcess delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<OrderProcess> search(String word) {
        return repository.findAll().stream()
                .filter(order -> order.getOrder().getNumberOfOrder()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<OrderProcess> sortByNumberOfProcess() {
        return repository.findAll().stream().sorted(Comparator.comparing(orderProcess -> orderProcess.getOrder().getNumberOfOrder()))
                .collect(Collectors.toList());
    }
}
