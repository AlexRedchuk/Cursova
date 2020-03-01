package edu.lex.cursova.dao.editionOrderLog.interfaces;

import edu.lex.cursova.model.EditionOrderLog;

import java.util.List;

public interface IEditionOrderLogDao {
    EditionOrderLog save(EditionOrderLog editionOrderLog);
    EditionOrderLog get(String id);
    List<EditionOrderLog> getAll();
    EditionOrderLog edit(EditionOrderLog editionOrderLog);
    EditionOrderLog delete (String id);
}
