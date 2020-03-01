package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.EditionOrderLog;
import edu.lex.cursova.service.editionOrderLog.impls.EditionOrderLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/editionOrderLog")
public class EditionOrderLogAPIController {
    @Autowired
    EditionOrderLogServiceImpl service;

    @RequestMapping("/list")
    List<EditionOrderLog> getAll() {
        return service.getAll();
    }
}
