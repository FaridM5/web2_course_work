package com.ada.edu.wm2.firstspringapp.controller;

import com.ada.edu.wm2.firstspringapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {
    this.defaultPerson = defaultPerson;
    this.secondPerson = seconPerson;
    private List personsList = new ArrayList(List.of(
            defaultPerson, secondPerson,
            new Person(1,"Ali","Aliyev"),
            new Person(1,"Manaf", "Aghazade"),
            new Person(1,"Gultaj", "Aliyev")));

    @Primary
    @Autowired
    private Person defaultPerson;

    @Autowired
    private final Person secondPerson;

    @GetMapping
    public  String getAllPersons(Model model){

        model.addAttribute("persons", list);
        return "person_list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model){
        model.addAttribute("person", defaultPerson);
        return "new_person_form";
    }
    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person newPerson){
        this.personsList.add(newPerson);
        return "redirect:/persons";
    }

}
