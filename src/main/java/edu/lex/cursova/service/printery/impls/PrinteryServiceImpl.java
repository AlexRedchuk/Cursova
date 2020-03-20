package edu.lex.cursova.service.printery.impls;

import edu.lex.cursova.repository.PrinteryRepository;
import edu.lex.cursova.model.Printery;
import edu.lex.cursova.service.printery.interfaces.IPrinteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PrinteryServiceImpl implements IPrinteryService {
    @Autowired
    PrinteryRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public Printery save(Printery printery) {
        return null;
    }

    @Override
    public Printery get(String id) {
        return null;
    }

    @Override
    public List<Printery> getAll() {
        return repository.findAll();
    }

    @Override
    public Printery edit(Printery printery) {
        return null;
    }

    @Override
    public Printery delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
