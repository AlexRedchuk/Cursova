package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.ContactPerson;
import edu.lex.cursova.service.contactPerson.impls.ContactPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactPerson")
public class ContactPersonAPIController {
    @Autowired
    ContactPersonServiceImpl service;

    @RequestMapping("/get/list")
    List<ContactPerson> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    ContactPerson getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ContactPerson create (@RequestBody ContactPerson contactPerson) {
        return service.save(contactPerson);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    ContactPerson edit (@RequestBody ContactPerson contactPerson) {
        return service.save(contactPerson);
    }

    @RequestMapping("/delete/{id}")
    ContactPerson delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
