package edu.lex.cursova.dao.editionDirection.impls;

import edu.lex.cursova.dao.editionDirection.interfaces.IEditionDirectionDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.EditionDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditionDirectionDaoImplFake implements IEditionDirectionDao {

    @Autowired
    DataSet dataSet;

    @Override
    public EditionDirection save(EditionDirection editionDirection) {
        return null;
    }

    @Override
    public EditionDirection get(String id) {
        return null;
    }

    @Override
    public List<EditionDirection> getAll() {
        return dataSet.getEditionDirections();
    }

    @Override
    public EditionDirection edit(EditionDirection editionDirection) {
        return null;
    }

    @Override
    public EditionDirection delete(String id) {
        return null;
    }
}
