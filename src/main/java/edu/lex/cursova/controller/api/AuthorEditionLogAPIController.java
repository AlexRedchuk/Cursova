package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.service.authorEditionLog.impls.AuthorEditionLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authorEditionLog")
public class AuthorEditionLogAPIController {
    @Autowired
    AuthorEditionLogServiceImpl service;

    @RequestMapping("/list")
    List<AuthorEditionLog> getAll() {
        return service.getAll();
    }
}
