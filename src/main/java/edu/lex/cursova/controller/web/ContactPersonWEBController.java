package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.ContactPersonForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.ContactPerson;
import edu.lex.cursova.service.contactPerson.impls.ContactPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("web/contactPerson")
public class ContactPersonWEBController {
    @Autowired
    ContactPersonServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("contactPersons", service.getAll());
        return "contactPersonList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<ContactPerson> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("contactPersons", list);
        return "contactPersonList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sortAuthor(Model model){
        List<ContactPerson> list = service.sortByName();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("contactPersons", list);
        model.addAttribute("searchForm", searchForm);
        return "contactPersonList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSortedByAuthor(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<ContactPerson> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("contactPersons", list);
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