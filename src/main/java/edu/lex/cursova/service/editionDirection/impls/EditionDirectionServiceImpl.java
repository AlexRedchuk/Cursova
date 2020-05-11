package edu.lex.cursova.service.editionDirection.impls;

import edu.lex.cursova.model.Author;
import edu.lex.cursova.repository.EditionDirectionRepository;
import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.service.editionDirection.interfaces.IEditionDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionDirectionServiceImpl implements IEditionDirectionService {
    @Autowired
    EditionDirectionRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public EditionDirection save(EditionDirection editionDirection) {
        return repository.save(editionDirection);
    }

    @Override
    public EditionDirection get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EditionDirection> getAll() {
        return repository.findAll();
    }

    @Override
    public EditionDirection edit(EditionDirection editionDirection) {
        return repository.save(editionDirection);
    }

    @Override
    public EditionDirection delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<EditionDirection> search(String word) {
        return repository.findAll().stream()
                .filter(editionDirection -> editionDirection.getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<EditionDirection> sortByName() {
        return repository.findAll().stream().sorted(Comparator.comparing(EditionDirection::getName))
                .collect(Collectors.toList());
    }
}
