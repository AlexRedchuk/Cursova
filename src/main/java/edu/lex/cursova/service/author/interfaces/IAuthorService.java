package edu.lex.cursova.service.author.interfaces;

import edu.lex.cursova.model.Author;

import java.util.List;

public interface IAuthorService {
    Author save(Author author);
    Author get(String id);
    List<Author> getAll();
    Author edit(Author author);
    Author delete(String id);
}
