package edu.lex.cursova.controller.web;

import edu.lex.cursova.form.PrinteryForm;
import edu.lex.cursova.model.Printery;
import edu.lex.cursova.service.printery.impls.PrinteryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/printery")
public class PrinteryWEBController {
    @Autowired
    PrinteryServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("printeries", service.getAll());
        return "printeryList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("printeries", service.getAll());
        return "redirect:/web/printery/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        PrinteryForm printeryForm = new PrinteryForm();
        model.addAttribute("printeryForm", printeryForm);
        return "printeryAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("printeryForm") PrinteryForm printeryForm) {
        Printery printery = new Printery();
        printery.setName(printeryForm.getName());
        printery.setAddress(printeryForm.getAddress());
        printery.setPhoneNumber(printeryForm.getPhoneNumber());
        service.save(printery);
        model.addAttribute("printeries", service.getAll());
        return "redirect:/web/printery/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Printery printery = service.get(id);
        PrinteryForm printeryForm = new PrinteryForm();
        printeryForm.setName(printery.getName());
        printeryForm.setAddress(printery.getAddress());
        printeryForm.setPhoneNumber(printery.getPhoneNumber());
        model.addAttribute("printeryForm", printeryForm);
        return "printeryAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("printeryForm") PrinteryForm printeryForm) {
        Printery printery = new Printery();
        printery.setId(id);
        printery.setName(printeryForm.getName());
        printery.setAddress(printeryForm.getAddress());
        printery.setPhoneNumber(printeryForm.getPhoneNumber());
        service.save(printery);
        model.addAttribute("printeries", service.getAll());
        return "redirect:/web/printery/list";
    }
}
