package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Printery;
import edu.lex.cursova.service.printery.impls.PrinteryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/printery")
public class PrinteryAPIController {

    @Autowired
    PrinteryServiceImpl service;

    @RequestMapping("/get/list")
    List<Printery> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Printery getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Printery create (@RequestBody Printery printery) {
        return service.save(printery);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Printery edit (@RequestBody Printery printery) {
        return service.save(printery);
    }

    @RequestMapping("/delete/{id}")
    Printery delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
