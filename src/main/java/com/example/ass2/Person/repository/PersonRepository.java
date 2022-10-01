package com.example.ass2.Person.repository;

import com.example.ass2.Person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContaining(String keyword);
}
