package edu.lex.cursova.service.editionDirection.impls;

import edu.lex.cursova.dao.editionDirection.impls.EditionDirectionDaoImplFake;
import edu.lex.cursova.dao.repository.EditionDirectionRepository;
import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.service.editionDirection.interfaces.IEditionDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class EditionDirectionServiceImpl implements IEditionDirectionService {


    @Autowired
    EditionDirectionDaoImplFake dao;

    @Autowired
    EditionDirectionRepository repository;

    @PostConstruct
    void init(){
        List<EditionDirection> list = dao.getAll();

        repository.saveAll(list);
    }

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
        return repository.findAll();
    }

    @Override
    public EditionDirection edit(EditionDirection editionDirection) {
        return null;
    }

    @Override
    public EditionDirection delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
