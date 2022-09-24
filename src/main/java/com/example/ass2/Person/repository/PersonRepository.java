package com.example.ass2.Person.repository;

import com.example.ass2.Person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
