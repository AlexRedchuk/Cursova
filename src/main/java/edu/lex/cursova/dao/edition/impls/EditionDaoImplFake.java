package edu.lex.cursova.dao.edition.impls;

import edu.lex.cursova.dao.edition.interfaces.IEditionDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.Edition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditionDaoImplFake implements IEditionDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Edition save(Edition edition) {
        return null;
    }

    @Override
    public Edition get(String id) {
        return null;
    }

    @Override
    public List<Edition> getAll() {
        return dataSet.getEditions();
    }

    @Override
    public Edition edit(Edition edition) {
        return null;
    }

    @Override
    public Edition delete(String id) {
        return null;
    }
}
