package edu.lex.cursova.dao.author.impls;

import edu.lex.cursova.dao.author.interfaces.IAuthorDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDaoImplFake implements IAuthorDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Author save(Author author) {
        dataSet.getAuthors().add(author);
        return author;
    }

    @Override
    public Author get(String id) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return dataSet.getAuthors();
    }

    @Override
    public Author edit(Author author) {
        return null;
    }

    @Override
    public Author delete(String id) {
        return null;
    }
}
