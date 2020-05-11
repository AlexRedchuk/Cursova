package edu.lex.cursova.service.edition.impls;

import edu.lex.cursova.model.Author;
import edu.lex.cursova.repository.EditionRepository;
import edu.lex.cursova.model.Edition;
import edu.lex.cursova.service.edition.interfaces.IEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionServiceImpl implements IEditionService {
    @Autowired
    EditionRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public Edition save(Edition edition) {
        return repository.save(edition);
    }

    @Override
    public Edition get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Edition> getAll() {
        return repository.findAll();
    }

    @Override
    public Edition edit(Edition edition) {
        return repository.save(edition);
    }

    @Override
    public Edition delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Edition> search(String word) {
        return repository.findAll().stream()
                .filter(edition -> edition.getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Edition> sortByName() {
        return repository.findAll().stream().sorted(Comparator.comparing(Edition::getName))
                .collect(Collectors.toList());
    }

    public List<Edition> sortByNumberOfPages() {
        return repository.findAll().stream().sorted(Comparator.comparing(Edition::getNumberOfPages).reversed())
                .collect(Collectors.toList());
    }

    public List<Edition> sortByCirculation() {
        return repository.findAll().stream().sorted(Comparator.comparing(Edition::getCirculation).reversed())
                .collect(Collectors.toList());
    }

    public List<Edition> sortByEditionCode() {
        return repository.findAll().stream().sorted(Comparator.comparing(Edition::getEditionCode))
                .collect(Collectors.toList());
    }

    public List<Edition> sortByEditionDirection() {
        return repository.findAll().stream().sorted(Comparator.comparing(edition -> edition.getEditionDirection().getName()))
                .collect(Collectors.toList());
    }
}
