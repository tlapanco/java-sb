/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tl.curso.service.implementation;

import com.tl.curso.entities.Person;
import com.tl.curso.repository.PersonRepository;
import com.tl.curso.service.PersonService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author tl
 */
@Service
public class PersonServiceImplementation implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImplementation(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Person personToUpdate = personRepository.findById(id).orElse(null);
        if (personToUpdate != null) {
            personToUpdate.setName(person.getName());
            personToUpdate.setGender(person.getGender());
            personToUpdate.setActive(person.isActive());
            return personRepository.save(personToUpdate);
        } else
            return null;
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Long countPeople() {
        return personRepository.count();
    }

}
