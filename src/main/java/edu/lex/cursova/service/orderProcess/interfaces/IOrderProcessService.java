package edu.lex.cursova.service.orderProcess.interfaces;

import edu.lex.cursova.model.OrderProcess;

import java.util.List;

public interface IOrderProcessService {
    OrderProcess save(OrderProcess orderProcess);
    OrderProcess get(String id);
    List<OrderProcess> getAll();
    OrderProcess edit(OrderProcess orderProcess);
    OrderProcess delete (String id);
}
