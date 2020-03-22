package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.EditionDirection;
import edu.lex.cursova.service.editionDirection.impls.EditionDirectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editionDirection")
public class EditionDirectionAPIController  {

    @Autowired
    EditionDirectionServiceImpl service;

    @RequestMapping("/get/list")
    List<EditionDirection> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    EditionDirection getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    EditionDirection create (@RequestBody EditionDirection editionDirection) {
        return service.save(editionDirection);
    }

    @RequestMapping("/delete/{id}")
    EditionDirection delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}

