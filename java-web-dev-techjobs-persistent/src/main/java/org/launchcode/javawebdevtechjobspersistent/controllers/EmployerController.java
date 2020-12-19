package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;


    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {
//        model.addAttribute("title","Add Employer");
//        model.addAttribute("employer",employerRepository.findAll());
//        model.addAttribute("employer",employerRepository.save(newEmployer));
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Employer");
            return "employers/add";
        }
        employerRepository.save(newEmployer);

        return "redirect:../";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {
//        model.addAttribute("title","Add Employer");

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {

//            Employer employer = employerRepository.findAll();
//            model.addAttribute("employer", employer);
//            model.addAttribute("employer",employerRepository.findAll());
//            return "employers/view";
            return "redirect:../";
        }
    }
}