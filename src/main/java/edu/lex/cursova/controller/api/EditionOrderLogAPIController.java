package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.EditionOrderLog;
import edu.lex.cursova.service.editionOrderLog.impls.EditionOrderLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editionOrderLog")
public class EditionOrderLogAPIController {
    @Autowired
    EditionOrderLogServiceImpl service;

    @RequestMapping("/get/list")
    List<EditionOrderLog> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    EditionOrderLog getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    EditionOrderLog create (@RequestBody EditionOrderLog editionOrderLog) {
        return service.save(editionOrderLog);
    }

    @RequestMapping("/delete/{id}")
    EditionOrderLog delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
