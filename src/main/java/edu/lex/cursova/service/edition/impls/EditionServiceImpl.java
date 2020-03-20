package edu.lex.cursova.service.edition.impls;

import edu.lex.cursova.repository.EditionRepository;
import edu.lex.cursova.model.Edition;
import edu.lex.cursova.service.edition.interfaces.IEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class EditionServiceImpl implements IEditionService {
    @Autowired
    EditionRepository repository;

    @PostConstruct
    void init(){

    }

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
        return repository.findAll();
    }

    @Override
    public Edition edit(Edition edition) {
        return null;
    }

    @Override
    public Edition delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
