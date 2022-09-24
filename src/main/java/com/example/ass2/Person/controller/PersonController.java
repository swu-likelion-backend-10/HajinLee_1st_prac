package com.example.ass2.Person.controller;

import com.example.ass2.Person.dto.PersonDto;
import com.example.ass2.Person.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    private  final PersonService personService;

    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @GetMapping("/")
    public String list(){
        return "person/list.html";
    }

    @GetMapping("/person")
    public String write(){
        return "person/write.html";
    }

    @PostMapping("/person")
    public String write(PersonDto personDto){
        personService.savePerson(personDto);
        return "redirect:/";
    }
}
