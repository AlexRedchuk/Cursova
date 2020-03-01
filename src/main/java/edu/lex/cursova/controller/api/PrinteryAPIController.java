package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.Printery;
import edu.lex.cursova.service.printery.impls.PrinteryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/printery")
public class PrinteryAPIController {

    @Autowired
    PrinteryServiceImpl service;

    @RequestMapping("/list")
    List<Printery> getAll() {
        return service.getAll();
    }
}
