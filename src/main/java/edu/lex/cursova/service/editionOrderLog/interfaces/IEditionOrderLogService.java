package edu.lex.cursova.service.editionOrderLog.interfaces;

import edu.lex.cursova.model.EditionOrderLog;

import java.util.List;

public interface IEditionOrderLogService {
    EditionOrderLog save(EditionOrderLog editionOrderLog);
    EditionOrderLog get(String id);
    List<EditionOrderLog> getAll();
    EditionOrderLog edit(EditionOrderLog editionOrderLog);
    EditionOrderLog delete (String id);
}
