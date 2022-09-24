package com.example.ass2.Person.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //이름
    @Column(nullable = false)
    private String name;

    //나이
    @Column(nullable = false)
    private int age;

    //학과
    @Column(nullable = false)
    private String major;

    //자기소개
    @Column(nullable = false)
    private String intro;

    @Builder
    public Person(Long id, String name, int age, String major, String intro){
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.intro = intro;
    }
}
