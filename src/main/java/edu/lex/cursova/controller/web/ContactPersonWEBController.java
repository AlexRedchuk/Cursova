package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.ContactPersonForm;
import edu.lex.cursova.model.ContactPerson;
import edu.lex.cursova.service.contactPerson.impls.ContactPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("web/contactPerson")
public class ContactPersonWEBController {
    @Autowired
    ContactPersonServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("contactPersons", service.getAll());
        return "contactPersonList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("contactPersons", service.getAll());
        return "redirect:/web/contactPerson/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        ContactPersonForm contactPersonForm = new ContactPersonForm();
        model.addAttribute("contactPersonForm", contactPersonForm);
        return "contactPersonAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("contactPersonForm") ContactPersonForm contactPersonForm) {
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFullName(contactPersonForm.getFullName());
        contactPerson.setPhoneNumber(contactPersonForm.getPhoneNumber());
        contactPerson.setFax(contactPersonForm.getFax());
        service.save(contactPerson);
        model.addAttribute("contactPersons", service.getAll());
        return "redirect:/web/contactPerson/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        ContactPerson contactPerson = service.get(id);
        ContactPersonForm contactPersonForm = new ContactPersonForm();
        contactPersonForm.setFullName(contactPerson.getFullName());
        contactPersonForm.setPhoneNumber(contactPerson.getPhoneNumber());
        contactPersonForm.setFax(contactPerson.getFax());
        model.addAttribute("contactPersonForm", contactPersonForm);
        return "contactPersonAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("contactPersonForm") ContactPersonForm contactPersonForm) {
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setId(id);
        contactPerson.setFullName(contactPersonForm.getFullName());
        contactPerson.setPhoneNumber(contactPersonForm.getPhoneNumber());
        contactPerson.setFax(contactPersonForm.getFax());
        service.save(contactPerson);
        model.addAttribute("contactPersons", service.getAll());
        return "redirect:/web/contactPerson/list";
    }
}