package edu.lex.cursova.service.author.impls;

import edu.lex.cursova.repository.AuthorRepository;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.service.author.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    AuthorRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public Author get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author edit(Author author) {
        return repository.save(author);
    }

    @Override
    public Author delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Author> search(String word) {
        return repository.findAll().stream()
                .filter(author -> author.getFullName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Author> sortByName() {
        return repository.findAll().stream().sorted(Comparator.comparing(Author::getFullName))
                .collect(Collectors.toList());
    }
}
