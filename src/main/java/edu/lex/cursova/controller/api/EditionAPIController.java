package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Edition;
import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edition")
public class EditionAPIController {
    @Autowired
    EditionServiceImpl service;

    @RequestMapping("/get/list")
    List<Edition> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Edition getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Edition create (@RequestBody Edition edition) {
        return service.save(edition);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Edition edit (@RequestBody Edition edition) {
        return service.save(edition);
    }

    @RequestMapping("/delete/{id}")
    Edition delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}