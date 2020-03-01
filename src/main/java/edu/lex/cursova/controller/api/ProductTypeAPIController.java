package edu.lex.cursova.controller.api;

import edu.lex.cursova.model.ProductType;
import edu.lex.cursova.service.productType.impls.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productType")
public class ProductTypeAPIController {

    @Autowired
    ProductTypeServiceImpl service;

    @RequestMapping("/list")
    List<ProductType> getAll() {
        return service.getAll();
    }
}