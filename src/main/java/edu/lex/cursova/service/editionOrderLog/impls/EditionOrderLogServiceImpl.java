package edu.lex.cursova.service.editionOrderLog.impls;

import edu.lex.cursova.dao.editionOrderLog.impls.EditionOrderLogDaoImplFake;
import edu.lex.cursova.dao.repository.EditionOrderLogRepository;
import edu.lex.cursova.model.EditionOrderLog;
import edu.lex.cursova.service.editionOrderLog.interfaces.IEditionOrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class EditionOrderLogServiceImpl implements IEditionOrderLogService {

    @Autowired
    EditionOrderLogDaoImplFake dao;

    @Autowired
    EditionOrderLogRepository repository;

    @PostConstruct
    void init() {
        List<EditionOrderLog> list = dao.getAll();

        repository.saveAll(list);
    }

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
        return repository.findAll();
    }

    @Override
    public EditionOrderLog edit(EditionOrderLog editionOrderLog) {
        return null;
    }

    @Override
    public EditionOrderLog delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
