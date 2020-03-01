package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Edition;
import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/edition")
public class EditionAPIController {
    @Autowired
    EditionServiceImpl service;

    @RequestMapping("/list")
    List<Edition> getAll() {
        return service.getAll();
    }
}