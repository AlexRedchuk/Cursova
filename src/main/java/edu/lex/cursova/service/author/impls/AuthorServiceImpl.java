package edu.lex.cursova.service.author.impls;

import edu.lex.cursova.repository.AuthorRepository;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.service.author.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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
        return null;
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author edit(Author author) {
        return null;
    }

    @Override
    public Author delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
