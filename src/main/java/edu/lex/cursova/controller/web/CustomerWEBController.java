package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.CustomerForm;
import edu.lex.cursova.form.OrderForm;
import edu.lex.cursova.model.*;
import edu.lex.cursova.service.contactPerson.impls.ContactPersonServiceImpl;
import edu.lex.cursova.service.customer.impls.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/customer")
public class CustomerWEBController {
    @Autowired
    CustomerServiceImpl service;

    @Autowired
    ContactPersonServiceImpl contactPersonService;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customerList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("customers", service.getAll());
        return "redirect:/web/customer/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CustomerForm customerForm = new CustomerForm();

        List types = Arrays.asList(OrganisationType.values());

        List<String> contactPersonList = contactPersonService.getAll().stream()
                .map(ContactPerson::getFullName).collect(Collectors.toList());

        model.addAttribute("customerForm", customerForm);
        model.addAttribute("typesL", types);
        model.addAttribute("contactPersonsL", contactPersonList);
        return "customerAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("customerForm") CustomerForm customerForm) {
        Customer customer = new Customer();
        customer.setId(null);
        OrganisationType type = OrganisationType.ORGANISATION;
        String organisationType = customerForm.getType();
        switch (organisationType) {
            case "ORGANISATION": type = OrganisationType.ORGANISATION;
                break;
            case "PRIVATE": type = OrganisationType.PRIVATE;
                break;
        }
        customer.setType(type);
        customer.setName(customerForm.getName());
        ContactPerson contactPerson = contactPersonService.getAll().stream()
                .filter(item -> item.getFullName().equals(customerForm.getContactPerson()) )
                .findFirst().orElse(new ContactPerson());
        customer.setContactPerson(contactPerson);
        customer.setAddress(customerForm.getAddress());
        customer.setFax(customerForm.getFax());
        service.save(customer);
        model.addAttribute("customers", service.getAll());
        return "redirect:/web/customer/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        CustomerForm customerForm = new CustomerForm();
        Customer customer = service.get(id);
        customerForm.setType(customer.getType().toString());
        customerForm.setName(customer.getName());
        customerForm.setContactPerson(customer.getContactPerson().getFullName());
        customerForm.setAddress(customer.getAddress());
        customerForm.setFax(customer.getFax());
        List<String> contactPersonList = contactPersonService.getAll().stream()
                .map(ContactPerson::getFullName).collect(Collectors.toList());
        List types = Arrays.asList(OrganisationType.values());
        model.addAttribute("typesL",types);
        model.addAttribute("contactPersonsL", contactPersonList);
        model.addAttribute("customerForm", customerForm);
        return "customerAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("customerForm") CustomerForm customerForm) {
        ContactPerson contactPerson = contactPersonService.getAll().stream()
                .filter(item -> item.getFullName().equals(customerForm.getContactPerson()) )
                .findFirst().orElse(new ContactPerson());
        OrganisationType type = null;
        String organisationType = customerForm.getType();
        switch (organisationType) {
            case "ORGANISATION": type = OrganisationType.ORGANISATION;
                break;
            case "PRIVATE": type = OrganisationType.PRIVATE;
                break;
        }
        Customer customerEdited = new Customer();
        customerEdited.setId(id);
        customerEdited.setType(type);
        customerEdited.setName(customerForm.getName());
        customerEdited.setContactPerson(contactPerson);
        customerEdited.setAddress(customerForm.getAddress());
        customerEdited.setFax(customerForm.getFax());
        service.edit(customerEdited);
        model.addAttribute("customers", service.getAll());
        return "redirect:/web/customer/list";
    }
}