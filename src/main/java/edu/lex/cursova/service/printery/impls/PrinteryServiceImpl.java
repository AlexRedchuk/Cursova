package edu.lex.cursova.service.printery.impls;

import edu.lex.cursova.model.Edition;
import edu.lex.cursova.model.Order;
import edu.lex.cursova.repository.PrinteryRepository;
import edu.lex.cursova.model.Printery;
import edu.lex.cursova.service.printery.interfaces.IPrinteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrinteryServiceImpl implements IPrinteryService {
    @Autowired
    PrinteryRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public Printery save(Printery printery) {
        return repository.save(printery);
    }

    @Override
    public Printery get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Printery> getAll() {
        return repository.findAll();
    }

    @Override
    public Printery edit(Printery printery) {
        return repository.save(printery);
    }

    @Override
    public Printery delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Printery> search(String word) {
        return repository.findAll().stream()
                .filter(order -> order.getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Printery> sortByName() {
        return repository.findAll().stream().sorted(Comparator.comparing(Printery::getName))
                .collect(Collectors.toList());
    }

    public List<Printery> sortByAddress() {
        return repository.findAll().stream().sorted(Comparator.comparing(Printery::getAddress))
                .collect(Collectors.toList());
    }
}
