package edu.lex.cursova.service.authorEditionLog.impls;

import edu.lex.cursova.repository.AuthorEditionLogRepository;
import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.service.authorEditionLog.interfaces.IAuthorEditionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<AuthorEditionLog> search(String word) {
        List<AuthorEditionLog> authorSearch = repository.findAll().stream()
                .filter(authorEditionLog -> authorEditionLog.getAuthor().getFullName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        List<AuthorEditionLog> editionSearch = repository.findAll().stream()
                .filter(authorEditionLog -> authorEditionLog.getEdition().getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        List<AuthorEditionLog> finalSearch = authorSearch;
        finalSearch.removeAll(editionSearch);
        finalSearch.addAll(editionSearch);

        return finalSearch;
    }

    public List<AuthorEditionLog> sortByAuthor() {
        return repository.findAll().stream().sorted(Comparator.comparing(a -> a.getAuthor().getFullName()))
                .collect(Collectors.toList());
    }

    public List<AuthorEditionLog> sortByEdition() {
        return repository.findAll().stream().sorted(Comparator.comparing(a -> a.getEdition().getName()))
                .collect(Collectors.toList());
    }
}
