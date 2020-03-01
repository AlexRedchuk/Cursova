package edu.lex.cursova.dao.printery.impls;

import edu.lex.cursova.dao.printery.interfaces.IPrinteryDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.Printery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrinteryDaoImplFake implements IPrinteryDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Printery save(Printery printery) {
        return null;
    }

    @Override
    public Printery get(String id) {
        return null;
    }

    @Override
    public List<Printery> getAll() {
        return dataSet.getPrinteries();
    }

    @Override
    public Printery edit(Printery printery) {
        return null;
    }

    @Override
    public Printery delete(String id) {
        return null;
    }
}
