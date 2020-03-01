package edu.lex.cursova.service.edition.interfaces;

import edu.lex.cursova.model.Edition;

import java.util.List;

public interface IEditionService {
    Edition save(Edition edition);
    Edition get(String id);
    List<Edition> getAll();
    Edition edit(Edition edition);
    Edition delete (String id);
}

