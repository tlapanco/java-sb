package com.tl.curso.service;

import com.tl.curso.entities.Person;
import java.util.List;

/**
 *
 * @author tl
 */
public interface PersonService {

    List<Person> getAll();

    Person getById(Long id);

    Person createPerson(Person person);

    Person updatePerson(Long id, Person person);

    void deletePerson(Long id);

    Long countPeople();
}
