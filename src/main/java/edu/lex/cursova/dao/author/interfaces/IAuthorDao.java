package edu.lex.cursova.dao.author.interfaces;

import edu.lex.cursova.model.Author;

import java.util.List;

public interface IAuthorDao {
    Author save(Author author);
    Author get(String id);
    List<Author> getAll();
    Author edit(Author author);
    Author delete(String id);
}
