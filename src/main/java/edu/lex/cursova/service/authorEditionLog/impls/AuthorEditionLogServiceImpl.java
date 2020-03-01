package edu.lex.cursova.service.authorEditionLog.impls;

import edu.lex.cursova.dao.authorEditionLog.impls.AuthorEditionLogDaoImplFake;
import edu.lex.cursova.dao.repository.AuthorEditionLogRepository;
import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.service.authorEditionLog.interfaces.IAuthorEditionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AuthorEditionLogServiceImpl implements IAuthorEditionLogService {

    @Autowired
    AuthorEditionLogDaoImplFake dao;

    @Autowired
    AuthorEditionLogRepository repository;

    @PostConstruct
    void init(){
        List<AuthorEditionLog> list = dao.getAll();

        repository.saveAll(list);
    }

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
        return repository.findAll();
    }

    @Override
    public AuthorEditionLog edit(AuthorEditionLog orderProcess) {
        return null;
    }

    @Override
    public AuthorEditionLog delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
