package com.example.ass2.Person.service;

import com.example.ass2.Person.controller.PersonController;
import com.example.ass2.Person.domain.Person;
import com.example.ass2.Person.dto.PersonDto;
import com.example.ass2.Person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public List<PersonDto> getPersonlist(){
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();

        for(Person person: persons){
            PersonDto personDto = PersonDto.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .age(person.getAge())
                    .createdTime(person.getCreatedTime())
                    .modifiedTime(person.getModifiedTime())
                    .build();

            personDtoList.add(personDto);
        }

        return personDtoList;
    }

    @Transactional
    public PersonDto getPerson(Long id){
        Optional<Person> personWrapper = personRepository.findById(id);
        Person person = personWrapper.get();

        PersonDto personDto = PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .major(person.getMajor())
                .intro(person.getIntro())
                .createdTime(person.getCreatedTime())
                .modifiedTime(person.getModifiedTime())
                .build();

        return personDto;
    }

    @Transactional
    public Long updatePerson(Long id, PersonDto personDto){
        Person person = personRepository.findById(id).orElseThrow(()
                ->new IllegalArgumentException("해당 게시글은 존재하지 않습니다. " + id));
        person.update(personDto);

        return id;
    }

    @Transactional
    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
