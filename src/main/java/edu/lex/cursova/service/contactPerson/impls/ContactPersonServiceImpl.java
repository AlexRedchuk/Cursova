package edu.lex.cursova.service.contactPerson.impls;

import edu.lex.cursova.repository.ContactPersonRepository;
import edu.lex.cursova.model.ContactPerson;
import edu.lex.cursova.service.contactPerson.interfaces.IContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactPersonServiceImpl implements IContactPersonService {
    @Autowired
    ContactPersonRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public ContactPerson save(ContactPerson contactPerson) {
        return repository.save(contactPerson);
    }

    @Override
    public ContactPerson get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ContactPerson> getAll() {
        return repository.findAll();
    }

    @Override
    public ContactPerson edit(ContactPerson contactPerson) {
        return repository.save(contactPerson);
    }

    @Override
    public ContactPerson delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<ContactPerson> search(String word) {
        return repository.findAll().stream()
                .filter(contactPerson -> contactPerson.getFullName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ContactPerson> sortByName() {
        return repository.findAll().stream().sorted(Comparator.comparing(ContactPerson::getFullName))
                .collect(Collectors.toList());
    }
}
