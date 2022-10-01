package com.example.ass2.Person.controller;

import com.example.ass2.Person.dto.PersonDto;
import com.example.ass2.Person.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {
    private  final PersonService personService;

    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<PersonDto> personDtoList = personService.getPersonlist();
        model.addAttribute("personList", personDtoList);


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

    @GetMapping("/person/{no}")
    public String detail(@PathVariable("no") Long id, Model model){
        PersonDto personDto = personService.getPerson(id);

        model.addAttribute("personDto", personDto);
        return "person/detail.html";
    }

    @GetMapping("/person/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model){
        PersonDto personDto = personService.getPerson(id);
        model.addAttribute("personDto", personDto);
        return "person/update.html";
    }

    @PutMapping("/person/edit/{no}")
    public String update(@PathVariable("no") Long id, PersonDto personDto){
        personService.updatePerson(id, personDto);
        return "redirect:/person/{no}";
    }

    @DeleteMapping("person/delete/{no}")
    public String delete(@PathVariable("no") Long id){
        personService.deletePerson(id);
        return "redirect:/";
    }

}
