package edu.lex.cursova.dao.editionDirection.interfaces;

import edu.lex.cursova.model.EditionDirection;

import java.util.List;

public interface IEditionDirectionDao {
    EditionDirection save(EditionDirection editionDirection);
    EditionDirection get(String id);
    List<EditionDirection> getAll();
    EditionDirection edit(EditionDirection editionDirection);
    EditionDirection delete (String id);
}
