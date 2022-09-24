package com.example.ass2.Person.service;

import com.example.ass2.Person.controller.PersonController;
import com.example.ass2.Person.dto.PersonDto;
import com.example.ass2.Person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Transactional
    public Long savePerson(PersonDto personDto){
        return personRepository.save(personDto.toEntity()).getId();
    }
}
