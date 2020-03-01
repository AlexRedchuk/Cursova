package edu.lex.cursova.dao.authorEditionLog.impls;

import edu.lex.cursova.dao.authorEditionLog.interfaces.IAuthorEditionLogDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.AuthorEditionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorEditionLogDaoImplFake implements IAuthorEditionLogDao {

    @Autowired
    DataSet dataSet;

    @Override
    public AuthorEditionLog save(AuthorEditionLog orderProcess) {
        return null;
    }

    @Override
    public AuthorEditionLog get(String id) {
        return null;
    }

    @Override
    public List<AuthorEditionLog> getAll() {
        return dataSet.getAuthorEditionLogs();
    }

    @Override
    public AuthorEditionLog edit(AuthorEditionLog orderProcess) {
        return null;
    }

    @Override
    public AuthorEditionLog delete(String id) {
        return null;
    }
}
