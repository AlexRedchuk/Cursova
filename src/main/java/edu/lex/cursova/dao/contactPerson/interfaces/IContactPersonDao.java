package edu.lex.cursova.dao.contactPerson.interfaces;

import edu.lex.cursova.model.ContactPerson;

import java.util.List;

public interface IContactPersonDao {
    ContactPerson save(ContactPerson contactPerson);
    ContactPerson get(String id);
    List<ContactPerson> getAll();
    ContactPerson edit(ContactPerson contactPerson);
    ContactPerson delete (String id);
}
