package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.AuthorForm;
import edu.lex.cursova.form.SearchForm;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.service.author.impls.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("web/author")
public class AuthorWEBController {
    @Autowired
    AuthorServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("authors", service.getAll());
        return "authorList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Author> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("authors", list);
        return "authorList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Author> list = service.sortByName();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("authors", list);
        model.addAttribute("searchForm", searchForm);
        return "authorList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getSearchField();
        List<Author> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("authors", list);
        return "authorList";
    }


    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("authors", service.getAll());
        return "redirect:/web/author/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        AuthorForm authorForm = new AuthorForm();
        model.addAttribute("authorForm", authorForm);
        return "authorAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("authorForm")@Valid AuthorForm authorForm, BindingResult bindingResult) {
        Author author = new Author();
        author.setFullName(authorForm.getFullName());
        author.setAddress(authorForm.getAddress());
        author.setPhoneNumber(authorForm.getPhoneNumber());
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("fullName")){
                System.out.println("Validation error(Author table): Unvalid name entered");
            }
            if(bindingResult.hasFieldErrors("address")){
                System.out.println("Validation error(Author table): Unvalid address entered");
            }
            if(bindingResult.hasFieldErrors("phoneNumber")){
                System.out.println("Validation error(Author table): Unvalid phone number entered");
            }
            return "authorAdd";
        }
        service.save(author);
        model.addAttribute("authors", service.getAll());
        return "redirect:/web/author/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Author author = service.get(id);
        AuthorForm authorForm = new AuthorForm();
        authorForm.setFullName(author.getFullName());
        authorForm.setAddress(author.getAddress());
        authorForm.setPhoneNumber(author.getPhoneNumber());
        model.addAttribute("authorForm", authorForm);
        return "authorAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("authorForm")@Valid AuthorForm authorForm, BindingResult bindingResult) {
        Author author = new Author();
        author.setId(id);
        author.setFullName(authorForm.getFullName());
        author.setAddress(authorForm.getAddress());
        author.setPhoneNumber(authorForm.getPhoneNumber());
        if(bindingResult.hasErrors()) {
            if(bindingResult.hasFieldErrors("fullName")){
                System.out.println("Validation error(Author table): Unvalid name entered");
            }
            if(bindingResult.hasFieldErrors("address")){
                System.out.println("Validation error(Author table): Unvalid address entered");
            }
            if(bindingResult.hasFieldErrors("phoneNumber")){
                System.out.println("Validation error(Author table): Unvalid phone number entered");
            }
            return "authorAdd";
        }
        service.save(author);
        model.addAttribute("authors", service.getAll());
        return "redirect:/web/author/list";
    }
}
