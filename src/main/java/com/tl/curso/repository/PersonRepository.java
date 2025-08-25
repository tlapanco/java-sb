package com.tl.curso.repository;

import com.tl.curso.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tl
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
