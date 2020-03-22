package edu.lex.cursova.service.authorEditionLog.impls;

import edu.lex.cursova.repository.AuthorEditionLogRepository;
import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.service.authorEditionLog.interfaces.IAuthorEditionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AuthorEditionLogServiceImpl implements IAuthorEditionLogService {

    @Autowired
    AuthorEditionLogRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public AuthorEditionLog save(AuthorEditionLog authorEditionLog) {
        return repository.save(authorEditionLog);
    }

    @Override
    public AuthorEditionLog get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AuthorEditionLog> getAll() {
        return repository.findAll();
    }

    @Override
    public AuthorEditionLog edit(AuthorEditionLog authorEditionLog) {
        return repository.save(authorEditionLog);
    }

    @Override
    public AuthorEditionLog delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
