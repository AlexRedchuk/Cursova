package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.service.authorEditionLog.impls.AuthorEditionLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authorEditionLog")
public class AuthorEditionLogAPIController {
    @Autowired
    AuthorEditionLogServiceImpl service;

    @RequestMapping("/get/list")
    List<AuthorEditionLog> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    AuthorEditionLog getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    AuthorEditionLog create (@RequestBody AuthorEditionLog authorEditionLog) {
        return service.save(authorEditionLog);
    }

    @RequestMapping("/delete/{id}")
    AuthorEditionLog delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
