package edu.lex.cursova.dao.edition.interfaces;

import edu.lex.cursova.model.Edition;

import java.util.List;

public interface IEditionDao {
    Edition save(Edition edition);
    Edition get(String id);
    List<Edition> getAll();
    Edition edit(Edition edition);
    Edition delete (String id);
}
