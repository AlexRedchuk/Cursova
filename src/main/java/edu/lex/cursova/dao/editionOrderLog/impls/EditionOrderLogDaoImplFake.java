package edu.lex.cursova.dao.editionOrderLog.impls;

import edu.lex.cursova.dao.editionOrderLog.interfaces.IEditionOrderLogDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.EditionOrderLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditionOrderLogDaoImplFake implements IEditionOrderLogDao {

    @Autowired
    DataSet dataSet;

    @Override
    public EditionOrderLog save(EditionOrderLog editionOrderLog) {
        return null;
    }

    @Override
    public EditionOrderLog get(String id) {
        return null;
    }

    @Override
    public List<EditionOrderLog> getAll() {
        return dataSet.getEditionOrderLogs();
    }

    @Override
    public EditionOrderLog edit(EditionOrderLog editionOrderLog) {
        return null;
    }

    @Override
    public EditionOrderLog delete(String id) {
        return null;
    }
}
