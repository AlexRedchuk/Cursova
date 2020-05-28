package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.ProductType;
import edu.lex.cursova.service.productType.impls.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productType")
public class ProductTypeAPIController {

    @Autowired
    ProductTypeServiceImpl service;

    @RequestMapping("/get/list")
    List<ProductType> getAll() {
        return service.getAll();
    }

    @RequestMapping("get/{id}")
    ProductType getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ProductType create (@RequestBody ProductType productType) {
        return service.save(productType);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    ProductType edit (@RequestBody ProductType productType) {
        return service.save(productType);
    }

    @RequestMapping("/delete/{id}")
    ProductType delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}