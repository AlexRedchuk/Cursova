package edu.lex.cursova.dao.order.impls;

import edu.lex.cursova.dao.order.interfaces.IOrderDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImplFake implements IOrderDao {

    @Autowired
    DataSet dataSet;

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
        return dataSet.getOrders();
    }

    @Override
    public Order edit(Order order) {
        return null;
    }

    @Override
    public Order delete(String id) {
        return null;
    }
}
