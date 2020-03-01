package edu.lex.cursova.service.authorEditionLog.interfaces;

import edu.lex.cursova.model.AuthorEditionLog;

import java.util.List;

public interface IAuthorEditionLogService {
    AuthorEditionLog save(AuthorEditionLog orderProcess);
    AuthorEditionLog get(String id);
    List<AuthorEditionLog> getAll();
    AuthorEditionLog edit(AuthorEditionLog orderProcess);
    AuthorEditionLog delete (String id);
}
