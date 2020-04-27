package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.AuthorEditionLogForm;
import edu.lex.cursova.form.AuthorForm;
import edu.lex.cursova.model.Author;
import edu.lex.cursova.model.AuthorEditionLog;
import edu.lex.cursova.model.Edition;
import edu.lex.cursova.repository.AuthorRepository;
import edu.lex.cursova.repository.EditionRepository;
import edu.lex.cursova.service.author.impls.AuthorServiceImpl;
import edu.lex.cursova.service.authorEditionLog.impls.AuthorEditionLogServiceImpl;
import edu.lex.cursova.service.edition.impls.EditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/authorEditionLog")
public class AuthorEditionLogWEBController {
    @Autowired
    AuthorEditionLogServiceImpl service;

    @Autowired
    AuthorServiceImpl authorService;


    @Autowired
    EditionServiceImpl editionService;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("authorEditionLogs", service.getAll());
        return "authorEditionLogList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("authorEditionLogs", service.getAll());
        return "redirect:/web/authorEditionLog/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        AuthorEditionLogForm authorEditionLogForm = new AuthorEditionLogForm();

        Map<String, String> authorMap = authorService.getAll().stream()
                .collect(Collectors.toMap(Author::getId, Author::getFullName));

        Map<String, String> editionMap = editionService.getAll().stream()
                .collect(Collectors.toMap(Edition::getId, Edition::getName));

        List<String> authorList = authorService.getAll().stream()
                .map(Author::getFullName).collect(Collectors.toList());

        List<String> editionList = editionService.getAll().stream()
                .map(Edition::getName).collect(Collectors.toList());

        model.addAttribute("authorEditionLogForm", authorEditionLogForm);
        model.addAttribute("authors", authorMap);
        model.addAttribute("authorsL", authorList);
        model.addAttribute("editions", editionMap);
        model.addAttribute("editionsL", editionList);
        return "authorEditionLogAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("authorEditionLogForm") AuthorEditionLogForm authorEditionLogForm) {
        AuthorEditionLog authorEditionLog = new AuthorEditionLog();
        authorEditionLog.setId(null);
        Author author = authorService.getAll().stream()
                .filter(item -> item.getFullName().equals(authorEditionLogForm.getAuthor()) )
                .findFirst().orElse(new Author());
        authorEditionLog.setAuthor(author);
        Edition edition = editionService.getAll().stream()
                .filter(item -> item.getName().equals(authorEditionLogForm.getEdition()) )
                .findFirst().orElse(new Edition());
        authorEditionLog.setEdition(edition);
        authorEditionLog.setAdditionalInformation(authorEditionLogForm.getAdditionalInformation());
        service.save(authorEditionLog);
        model.addAttribute("authorEditionLogs", service.getAll());
        return "redirect:/web/authorEditionLog/list";
    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    String edit(Model model, @PathVariable("id") String id) {
//        Author author = service.get(id);
//        AuthorForm authorForm = new AuthorForm();
//        authorForm.setFullName(author.getFullName());
//        authorForm.setAddress(author.getAddress());
//        authorForm.setPhoneNumber(author.getPhoneNumber());
//        model.addAttribute("authorForm", authorForm);
//        return "authorAdd";
//    }
//
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("authorForm") AuthorForm authorForm) {
//        Author author = new Author();
//        author.setId(id);
//        author.setFullName(authorForm.getFullName());
//        author.setAddress(authorForm.getAddress());
//        author.setPhoneNumber(authorForm.getPhoneNumber());
//        service.save(author);
//        model.addAttribute("authors", service.getAll());
//        return "redirect:/web/author/list";
//    }
}
