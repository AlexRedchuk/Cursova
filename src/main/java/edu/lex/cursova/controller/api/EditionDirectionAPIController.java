package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.service.editionDirection.impls.EditionDirectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/editionDirection")
public class EditionDirectionAPIController  {

    @Autowired
    EditionDirectionServiceImpl service;

    @RequestMapping("/list")
    List<EditionDirection> getAll() {
        return service.getAll();
    }
}

