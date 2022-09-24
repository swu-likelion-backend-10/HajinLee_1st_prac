package com.example.ass2.Person.dto;

import com.example.ass2.Person.domain.Person;
import lombok.Builder;

public class PersonDto {
    private Long id;

    private String name;

    private int age;

    private String major;

    private String intro;

    public Person toEntity(){
        Person build = Person.builder()
                .id(id)
                .name(name)
                .age(age)
                .major(major)
                .intro(intro)
                .build();
        return build;
    }

    @Builder
    public PersonDto(Long id, String name, int age, String major, String intro){
        this.id=id;
        this.name=name;
        this.age=age;
        this.major=major;
        this.intro=intro;
    }
}
