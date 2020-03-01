package edu.lex.cursova.service.printery.interfaces;

import edu.lex.cursova.model.Printery;

import java.util.List;

public interface IPrinteryService {
    Printery save(Printery printery);
    Printery get(String id);
    List<Printery> getAll();
    Printery edit(Printery printery);
    Printery delete (String id);
}
