package edu.lex.cursova.service.editionOrderLog.impls;

import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.repository.EditionOrderLogRepository;
import edu.lex.cursova.model.EditionOrderLog;
import edu.lex.cursova.service.editionOrderLog.interfaces.IEditionOrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionOrderLogServiceImpl implements IEditionOrderLogService {
    @Autowired
    EditionOrderLogRepository repository;

    @PostConstruct
    void init() {

    }

    @Override
    public EditionOrderLog save(EditionOrderLog editionOrderLog) {
        return repository.save(editionOrderLog);
    }

    @Override
    public EditionOrderLog get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EditionOrderLog> getAll() {
        return repository.findAll();
    }

    @Override
    public EditionOrderLog edit(EditionOrderLog editionOrderLog) {
        return repository.save(editionOrderLog);
    }

    @Override
    public EditionOrderLog delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<EditionOrderLog> search(String word) {
        List<EditionOrderLog> orderSearch = repository.findAll().stream()
                .filter(authorEditionLog -> authorEditionLog.getOrder().getNumberOfOrder()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        List<EditionOrderLog> editionSearch = repository.findAll().stream()
                .filter(authorEditionLog -> authorEditionLog.getEdition().getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        List<EditionOrderLog> finalSearch = orderSearch;
        finalSearch.removeAll(editionSearch);
        finalSearch.addAll(editionSearch);

        return finalSearch;
    }

    public List<EditionOrderLog> sortByOrder() {
        return repository.findAll().stream().sorted(Comparator.comparing(editionOrderLog -> editionOrderLog.getOrder().getNumberOfOrder()))
                .collect(Collectors.toList());
    }

    public List<EditionOrderLog> sortByEdition() {
        return repository.findAll().stream().sorted(Comparator.comparing(editionOrderLog -> editionOrderLog.getEdition().getName()))
                .collect(Collectors.toList());
    }
}
