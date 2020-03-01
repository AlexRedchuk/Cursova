package edu.lex.cursova.service.printery.impls;

import edu.lex.cursova.dao.printery.impls.PrinteryDaoImplFake;
import edu.lex.cursova.dao.repository.PrinteryRepository;
import edu.lex.cursova.model.Printery;
import edu.lex.cursova.service.printery.interfaces.IPrinteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PrinteryServiceImpl implements IPrinteryService {

    @Autowired
    PrinteryDaoImplFake dao;

    @Autowired
    PrinteryRepository repository;

    @PostConstruct
    void init(){
        List<Printery> list = dao.getAll();

        repository.saveAll(list);
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
