package edu.lex.cursova.service.contactPerson.impls;

import edu.lex.cursova.repository.ContactPersonRepository;
import edu.lex.cursova.model.ContactPerson;
import edu.lex.cursova.service.contactPerson.interfaces.IContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ContactPersonServiceImpl implements IContactPersonService {
    @Autowired
    ContactPersonRepository repository;

    @PostConstruct
    void init(){

    }

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
        return repository.findAll();
    }

    @Override
    public ContactPerson edit(ContactPerson contactPerson) {
        return null;
    }

    @Override
    public ContactPerson delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
