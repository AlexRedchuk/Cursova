package edu.lex.cursova.service.order.impls;

import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.EditionOrderLog;
import edu.lex.cursova.repository.OrderRepository;
import edu.lex.cursova.model.Order;
import edu.lex.cursova.service.order.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderServiceImpl implements IOrderService {
    @Autowired
    OrderRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public Order get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order edit(Order order) {
        return repository.save(order);
    }

    @Override
    public Order delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Order> search(String word) {
        return repository.findAll().stream()
                .filter(order -> order.getNumberOfOrder()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Order> sortByNumberOfOrder() {
        return repository.findAll().stream().sorted(Comparator.comparing(Order::getNumberOfOrder))
                .collect(Collectors.toList());
    }

    public List<Order> sortByCustomer() {
        return repository.findAll().stream().sorted(Comparator.comparing(order -> order.getCustomer().getName()))
                .collect(Collectors.toList());
    }

    public List<Order> sortByType() {
        return repository.findAll().stream().sorted(Comparator.comparing(order -> order.getProductType().getName()))
                .collect(Collectors.toList());
    }

    public List<Order> sortByPrintery() {
        return repository.findAll().stream().sorted(Comparator.comparing(order -> order.getPrintery().getName()))
                .collect(Collectors.toList());
    }
}
