package edu.lex.cursova.dao.orderProcess.impls;

import edu.lex.cursova.dao.orderProcess.interfaces.IOrderProcessDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.OrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderProcessDaoImplFake implements IOrderProcessDao {

    @Autowired
    DataSet dataSet;

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
        return dataSet.getOrderProcesses();
    }

    @Override
    public OrderProcess edit(OrderProcess orderProcess) {
        return null;
    }

    @Override
    public OrderProcess delete(String id) {
        return null;
    }
}
