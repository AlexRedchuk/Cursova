package edu.lex.cursova.dao.orderProcess.interfaces;

import edu.lex.cursova.model.OrderProcess;

import java.util.List;

public interface IOrderProcessDao {
    OrderProcess save(OrderProcess orderProcess);
    OrderProcess get(String id);
    List<OrderProcess> getAll();
    OrderProcess edit(OrderProcess orderProcess);
    OrderProcess delete (String id);
}
