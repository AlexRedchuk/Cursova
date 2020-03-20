package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Author;
import edu.lex.cursova.service.author.impls.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.acl.Group;
import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorAPIController {
    @Autowired
    AuthorServiceImpl service;

    @RequestMapping("/get/list")
    List<Author> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    Author getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Author create (@RequestBody Author author) {
        return service.save(author);
    }

    @RequestMapping("/delete/{id}")
    Author delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
