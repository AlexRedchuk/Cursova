package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.ContactPerson;
import edu.lex.cursova.service.contactPerson.impls.ContactPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contactPerson")
public class ContactPersonAPIController {
    @Autowired
    ContactPersonServiceImpl service;

    @RequestMapping("/list")
    List<ContactPerson> getAll() {
        return service.getAll();
    }
}
