package com.example.ass2.Person.dto;

import com.example.ass2.Person.domain.Person;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PersonDto {
    private Long id;

    private String name;

    private int age;

    private String major;

    private String intro;

    private LocalDateTime createdTime;

    private LocalDateTime modifiedTime;

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
    public PersonDto(Long id, String name, int age, String major, String intro, LocalDateTime createdTime, LocalDateTime modifiedTime){
        this.id=id;
        this.name=name;
        this.age=age;
        this.major=major;
        this.intro=intro;
        this.createdTime=createdTime;
        this.modifiedTime=modifiedTime;
    }
}
