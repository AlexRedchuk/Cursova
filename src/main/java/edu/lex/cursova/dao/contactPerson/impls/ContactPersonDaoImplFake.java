package edu.lex.cursova.dao.contactPerson.impls;

import edu.lex.cursova.dao.contactPerson.interfaces.IContactPersonDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.ContactPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactPersonDaoImplFake implements IContactPersonDao {

    @Autowired
    DataSet dataSet;

    @Override
    public ContactPerson save(ContactPerson contactPerson) {
        return null;
    }

    @Override
    public ContactPerson get(String id) {
        return null;
    }

    @Override
    public List<ContactPerson> getAll() {
        return dataSet.getContactPeople();
    }

    @Override
    public ContactPerson edit(ContactPerson contactPerson) {
        return null;
    }

    @Override
    public ContactPerson delete(String id) {
        return null;
    }
}
